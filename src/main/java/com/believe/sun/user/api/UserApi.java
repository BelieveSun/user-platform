package com.believe.sun.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungj on 17-6-20.
 */
@RestController
@RequestMapping("/users")
public class UserApi {
    //create user
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity users(){
        return new ResponseEntity("success", HttpStatus.OK);
    }
    //select user

    //delete user (status < 0)
}
