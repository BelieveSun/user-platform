package com.believe.sun.user.api;

import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungj on 17-5-24.
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    private Logger logger = LoggerFactory.getLogger(TestApi.class);
    private final UserService userService;

    @Autowired
    public TestApi(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity test(){
        logger.debug("this is {} ",1);
        User user = new User();
        user.setCellphone("15680028134");
        user.setAccount("test12345");
        user.setSex(1);
        user.setAge("20");
        user.setPassword("abcd1234");
        user.setIdentity("宝妈");
        user.setRoles("1");
        User user1 = userService.creatUser(user);
        return new ResponseEntity(user1, HttpStatus.OK);
    }
}
