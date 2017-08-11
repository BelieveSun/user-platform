package com.believe.sun.user.api;

import com.believe.sun.shiro.authc.OauthToken;
import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import com.believe.sun.user.util.Error;
import com.believe.sun.user.util.ErrorCode;
import com.believe.sun.user.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sungj on 17-6-6.
 */
@RestController
public class LoginApi {

    private static final Logger logger = LoggerFactory.getLogger(LoginApi.class);
    private final UserService userService;

    @Autowired
    public LoginApi(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "登录",tags = "login",produces = "application/json")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserForm userForm){
        logger.info("user {} login at {}",userForm.getAccount(), DateFormat.getDateInstance());
        User user = userService.auth(new User(userForm));
        if(user == null){
            return ResultUtil.build(ErrorCode.LOGIN_FAILED);
        }
        Subject subject = SecurityUtils.getSubject();
        OauthToken token = new OauthToken("password",user.getAccount(),user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
        if(subject != null && subject.isAuthenticated()){
            Session session = subject.getSession(false);
            Map<String,Object> data = new HashMap<>();
            data.put("access_token",session.getId());
            data.put("userName",user.getAccount());
            data.put("cellphone",user.getCellphone());
            data.put("status",user.getStatus());
            return ResultUtil.build(ErrorCode.SUCCESS,data);
        }else {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }

    }

    //注册用户
    @ApiOperation("用户注册")
    @RequestMapping("/signup")
    public ResponseEntity signup(@RequestBody UserForm userForm){
        User user = new User(userForm);
        // user is exist ?
        Error exist = userService.exist(user);
        if( exist != null ){
            return ResultUtil.build(exist);
        }
        // create
        user = userService.createUser(user);
        OauthToken token = new OauthToken("password",user.getAccount(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
        if(subject != null && subject.isAuthenticated()){
            Session session = subject.getSession(false);
            Map<String,Object> data = new HashMap<>();
            data.put("access_token",session.getId());
            data.put("userName",user.getAccount());
            data.put("cellphone",user.getCellphone());
            return ResultUtil.build(ErrorCode.SUCCESS,data);
        }else {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
    }
    @ApiOperation("注册对密码进行慢加密,此处应改在前端实现")
    @RequestMapping("/signup/password")
    public ResponseEntity bcryptPassword(String password){
        if(password != null){
            String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
            return ResultUtil.build(ErrorCode.SUCCESS,hashpw);
        }
        return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
    }
    @ApiOperation("登录时获取慢加密盐值")
    @RequestMapping("/login/salt")
    public ResponseEntity getSalt(String username){
        if(username != null){
            User user = userService.findUserByAccount(username);
            if(user == null){
                user = userService.findUserByCellphone(username);
                if(user == null){
                    user = userService.findUserByEmail(username);
                }
            }
            if(user != null){
                String getsalt = getsalt(user.getPassword());
                return ResultUtil.build(ErrorCode.SUCCESS,getsalt);
            }
        }
        return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
    }

    public static String getsalt(String salt){
        String real_salt = null;

        char minor = (char) 0;
        int off = 0;


        int saltLength = salt.length();

        if (saltLength < 28) {
            throw new IllegalArgumentException("Invalid salt");
        }

        if (salt.charAt(0) != '$' || salt.charAt(1) != '2') {
            throw new IllegalArgumentException("Invalid salt version");
        }
        if (salt.charAt(2) == '$') {
            off = 3;
        }
        else {
            minor = salt.charAt(2);
            if (minor != 'a' || salt.charAt(3) != '$') {
                throw new IllegalArgumentException("Invalid salt revision");
            }
            off = 4;
        }

        if (saltLength - off < 25) {
            throw new IllegalArgumentException("Invalid salt");
        }

        // Extract number of rounds
        if (salt.charAt(off + 2) > '$') {
            throw new IllegalArgumentException("Missing salt rounds");
        }

        real_salt = salt.substring(0, off + 25);

        return real_salt;
    }
    //登出
}
