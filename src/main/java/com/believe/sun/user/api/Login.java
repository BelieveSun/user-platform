package com.believe.sun.user.api;

import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;

/**
 * Created by sungj on 17-6-6.
 */
@RestController
public class Login {

    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    private final UserService userService;

    @Autowired
    public Login(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "登录",tags = "login",produces = "application/json")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserForm userForm){
        logger.info("user {} login at {}",userForm.getAccount(), DateFormat.getDateInstance());
        User user = userService.findUser(new User(userForm));
        if(user != null){
            Factory<SecurityManager> factory =
                    new IniSecurityManagerFactory("classpath:shiro.ini");
            org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());

            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    //注册用户
}
