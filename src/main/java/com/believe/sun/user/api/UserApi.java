package com.believe.sun.user.api;

import com.believe.sun.user.model.Permission;
import com.believe.sun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by sungj on 17-6-20.
 */
@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired
    private UserService userService;

    //create user
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<String> users(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    //select user

    //delete user (status < 0)
    @RequestMapping("/{user}/permissions")
    public ResponseEntity<Map<String, Object>> getUserPermissions(@PathVariable String user){
        List<Permission> permissions = userService.findPermissions(user);
        Set<String> permissionSet = new HashSet<>();
        if(permissions != null && permissions.size() > 0){
            for (Permission permission : permissions){
                String name = permission.getName();
                permissionSet.add(name);
            }
        }
        Map<String,Object> response = new HashMap<>();
        response.put("error",0);
        response.put("data",permissionSet);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
