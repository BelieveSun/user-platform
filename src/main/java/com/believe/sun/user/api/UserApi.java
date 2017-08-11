package com.believe.sun.user.api;

import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import com.believe.sun.user.util.*;
import com.believe.sun.user.util.Error;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sungj on 17-6-20.
 */
@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<DataResult<PageInfo<User>>> users(@RequestParam String username,
                                                            @RequestParam String cellphone,
                                                            @RequestParam String email,
                                                            @RequestParam Integer status,
                                                            @RequestParam(value = "index", defaultValue = "1") Integer index,
                                                            @RequestParam(value = "size", defaultValue = "100") Integer size) {
        List<User> users = new ArrayList<>();
        if (username != null) {
            User user = userService.findUserByAccount(username);
            if (user == null) {
                return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
            }
            users.add(user);
            return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>(users, 1, size, 1));
        }
        if (cellphone != null) {
            User user = userService.findUserByCellphone(cellphone);
            if (user == null) {
                return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
            }
            users.add(user);
            return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>(users, 1, size, 1));
        }
        if (email != null) {
            User user = userService.findUserByEmail(email);
            if (user == null) {
                return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
            }
            users.add(user);
            return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>(users, 1, size, 1));
        }
        users = userService.findAllUser(status,index,size);
        return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>((PageList<User>) users));
    }

    @RequestMapping("/{user}/permissions")
    public ResponseEntity<Map<String, Object>> getUserPermissions(@PathVariable String user) {
        List<Permission> permissions = userService.findPermissions(user);
        Set<String> permissionSet = new HashSet<>();
        if (permissions != null && permissions.size() > 0) {
            for (Permission permission : permissions) {
                String name = permission.getName();
                permissionSet.add(name);
            }
        }
        Map<String, Object> response = new HashMap<>();
        response.put("error", 0);
        response.put("data", permissionSet);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
