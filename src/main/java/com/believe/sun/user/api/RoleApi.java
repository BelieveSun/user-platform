package com.believe.sun.user.api;

import com.believe.sun.user.model.Permission;
import com.believe.sun.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sungj on 17-7-14.
 */
@RestController
@RequestMapping("/roles")
public class RoleApi {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/{role}/permissions")
    public ResponseEntity<Map<String, Object>> getRolePermissions(@PathVariable String role){
        List<String> roles = new ArrayList<>();
        roles.add(role);
        List<Permission> permissionByRole = roleService.findPermissionByRole(roles);
        Map<String,Object> response = new HashMap<>();
        response.put("error",0);
        response.put("data",permissionByRole);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
