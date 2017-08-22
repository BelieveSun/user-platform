package com.believe.sun.user.api;

import com.believe.sun.shiro.authc.OauthToken;
import com.believe.sun.tool.Error;
import com.believe.sun.tool.ResultUtil;
import com.believe.sun.user.exception.UserNotFoundException;
import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import com.believe.sun.user.util.ErrorCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
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

    @ApiOperation(value = "登录", tags = "login", produces = "application/json")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserForm userForm) {
        User user;
        try {
            user = userService.auth(new User(userForm));
        } catch (UserNotFoundException e) {
            return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
        }
        logger.info("user {} login at {}", userForm.getAccount(), DateFormat.getDateInstance());
        if (user == null) {
            return ResultUtil.build(ErrorCode.LOGIN_FAILED);
        }
        Subject subject = SecurityUtils.getSubject();
        OauthToken token = new OauthToken("password", user.getAccount(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
        if (subject.isAuthenticated()) {
            Session session = subject.getSession(false);
            Map<String, Object> data = new HashMap<>();
            data.put("access_token", session.getId());
            data.put("userName", user.getAccount());
            data.put("cellphone", user.getCellphone());
            data.put("status", user.getStatus());
            return ResultUtil.build(ErrorCode.SUCCESS, data);
        } else {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }

    }

    //注册用户
    @ApiOperation(value = "用户注册", tags = "login", produces = "application/json")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserForm userForm) {
        User user = new User(userForm);
        // user is exist ?
        Error exist = userService.exist(user);
        if (exist != null) {
            return ResultUtil.build(exist);
        }
        // create
        user = userService.createUser(user);
        if (user == null) {
            return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
        }
        OauthToken token = new OauthToken("password", user.getAccount(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
        if (subject.isAuthenticated()) {
            Session session = subject.getSession(false);
            Map<String, Object> data = new HashMap<>();
            data.put("access_token", session.getId());
            data.put("userName", user.getAccount());
            data.put("cellphone", user.getCellphone());
            return ResultUtil.build(ErrorCode.SUCCESS, data);
        } else {
            return ResultUtil.build(ErrorCode.AUTH_FAILED);
        }
    }

    @ApiOperation(value = "注册对密码进行慢加密,此处应改在前端实现", tags = "login", produces = "application/json")
    @RequestMapping(value = "/signup/password", method = RequestMethod.POST)
    public ResponseEntity bcryptPassword(@RequestBody String password,
                                         @RequestParam(value = "salt", required = false) String salt) {
        if (password != null) {
            String hashpw;
            if (salt != null) {
                hashpw = BCrypt.hashpw(password, salt);
            } else {
                hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
            }
            return ResultUtil.build(ErrorCode.SUCCESS, hashpw);
        }
        return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
    }

    @ApiOperation(value = "登录时获取慢加密盐值", tags = "login", produces = "application/json")
    @RequestMapping(value = "/login/salt", method = RequestMethod.GET)
    public ResponseEntity getSalt(@ApiParam("登录用户") @RequestParam String principal) {
        if (principal != null) {
            User user = userService.findUserByAccount(principal);
            if (user == null) {
                user = userService.findUserByCellphone(principal);
                if (user == null) {
                    user = userService.findUserByEmail(principal);
                }
            }
            if (user != null) {
                String getsalt = getsalt(user.getPassword());
                return ResultUtil.build(ErrorCode.SUCCESS, getsalt);
            }
        }
        return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
    }

    @ApiOperation(value = "密码md5值",tags = "login", produces = "application/json")
    @RequestMapping(value = "/login/md5",method = RequestMethod.POST)
    public ResponseEntity passwordMd5(@RequestBody String password){
        if(password != null) {
            String md5Hex = DigestUtils.md5Hex(password);
            return ResultUtil.build(ErrorCode.SUCCESS,md5Hex);
        }
        return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
    }

    //登出
    @ApiOperation(value = "登出", tags = "login", produces = "application/json")
    @RequestMapping("/signout")
    public ResponseEntity signout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.build(ErrorCode.SUCCESS);
    }

    public static String getsalt(String salt) {
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
        } else {
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
}
