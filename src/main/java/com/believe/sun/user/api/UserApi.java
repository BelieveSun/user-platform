package com.believe.sun.user.api;

import com.believe.sun.tool.DataResult;
import com.believe.sun.tool.PageInfo;
import com.believe.sun.tool.ResultUtil;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.Role;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import com.believe.sun.user.util.ErrorCode;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by sungj on 17-6-20.
 */
@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", tags = "user", produces = "application/json")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<DataResult<PageInfo<User>>> users(@ApiParam(value = "用户名") @RequestParam(required = false) String username,
                                                            @ApiParam("电话号码") @RequestParam(required = false) String cellphone,
                                                            @ApiParam("邮箱") @RequestParam(required = false) String email,
                                                            @ApiParam("用户状态") @RequestParam(required = false) Integer status,
                                                            @ApiParam("当前页") @RequestParam(value = "index", required = false, defaultValue = "1") Integer index,
                                                            @ApiParam("页大小") @RequestParam(value = "size", required = false, defaultValue = "100") Integer size) {
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
        users = userService.findAllUser(status, index, size);
        return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>((PageList<User>) users));
    }

    @ApiOperation(value = "获取用户信息", tags = "user", produces = "application/json")
    @RequestMapping(value = "/{userId}", method = GET)
    public ResponseEntity getUser(@PathVariable("userId") Integer userId) {
        User user = userService.findUserById(userId);
        if (user == null) {
            return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
        }
        return ResultUtil.build(ErrorCode.SUCCESS, user);

    }

    @ApiOperation(value = "获取用户角色信息",tags = "user",produces = "application/json")
    @RequestMapping(value = {"/{userId}/roles","roles"},method = GET)
    public ResponseEntity<DataResult<Set<String>>> getUserRoles(@PathVariable(value = "userId",required = false) Integer userId,
                                                                @RequestParam(value = "username",required = false) String username){
        User user;
        if (userId == null) {
            user = userService.findUserByAccount(username);
        } else {
            user = userService.findUserById(userId);
        }
        if (user == null) {
            return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
        }
        List<Role> roles = userService.findRoles(user);
        Set<String> rolesSet = new HashSet<>();
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                String name = role.getRole();
                rolesSet.add(name);
            }
        }
        return ResultUtil.build(ErrorCode.SUCCESS, rolesSet);
    }

    @ApiOperation(value = "获取用户权限信息", tags = "user", produces = "application/json")
    @RequestMapping(value = {"/{userId}/permissions", "/permissions"}, method = GET)
    public ResponseEntity<DataResult<Set<String>>> getUserPermissions(@PathVariable(value = "userId",required = false) Integer userId,
                                                                      @RequestParam(value = "username", required = false) String username) {
        User user;
        if (userId == null) {
            user = userService.findUserByAccount(username);
        } else {
            user = userService.findUserById(userId);
        }
        if (user == null) {
            return ResultUtil.build(ErrorCode.USER_NOT_FOUND);
        }
        List<Permission> permissions = userService.findPermissions(user);
        Set<String> permissionSet = new HashSet<>();
        if (permissions != null && permissions.size() > 0) {
            for (Permission permission : permissions) {
                String name = permission.getName();
                permissionSet.add(name);
            }
        }
        return ResultUtil.build(ErrorCode.SUCCESS, permissionSet);
    }
}
