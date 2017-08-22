package com.believe.sun.user.api;

import com.believe.sun.tool.DataResult;
import com.believe.sun.tool.PageInfo;
import com.believe.sun.tool.ResultUtil;
import com.believe.sun.user.exception.RoleExistException;
import com.believe.sun.user.exception.RoleNotFoundException;
import com.believe.sun.user.form.RoleForm;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.Role;
import com.believe.sun.user.service.RoleService;
import com.believe.sun.user.util.*;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sungj on 17-7-14.
 */
@RestController
@RequestMapping("/roles")
public class RoleApi {

    private static final Logger logger = LoggerFactory.getLogger(RoleApi.class);

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色权限信息",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}/permissions",method = GET)
    public ResponseEntity<DataResult<List<Permission>>> getRolePermissions(@PathVariable("roleId") Integer roleId){
        List<Integer> roleIds = new ArrayList<>();
        roleIds.add(roleId);
        List<Permission> permissions = roleService.findPermissionByRoleIds(roleIds);
        return ResultUtil.build(ErrorCode.SUCCESS,permissions);
    }

    @ApiOperation(value = "添加角色权限",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}/permissions",method = POST)
    public ResponseEntity<DataResult<Role>> addPermission(@PathVariable("roleId") Integer roleId,
                                                          @ApiParam("添加的权限id字符串,用','号分割") @RequestBody String permissionIds){
        Role role = new Role();
        role.setId(roleId);
        role.setPermissionId(permissionIds);
        role = roleService.addPermission(role);
        return ResultUtil.build(ErrorCode.SUCCESS,role);
    }

    @ApiOperation(value = "删除角色权限",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}/permissions",method = DELETE)
    public ResponseEntity<DataResult<Role>> deletePermission(@PathVariable("roleId") Integer roleId,
                                                             @ApiParam("权限id字符串") @RequestParam("permissionIds") String permissionIds){
        Role role = new Role();
        role.setId(roleId);
        role.setPermissionId(permissionIds);
        role = roleService.deletePermission(role);
        return ResultUtil.build(ErrorCode.SUCCESS,role);
    }

    @ApiOperation(value = "创建角色",tags = "role",produces = "application/json")
    @RequestMapping(value = "",method = POST)
    public ResponseEntity<DataResult<Role>> createRole(@RequestBody RoleForm form){
        try {
            Role role = roleService.createRole(new Role(form));
            return ResultUtil.build(ErrorCode.SUCCESS,role);
        } catch (RoleExistException e) {
            logger.info("role : {} is exist !",form.getRole());
            return ResultUtil.build(ErrorCode.ROLE_EXIST);
        }
    }

    @ApiOperation(value = "获取角色列表",tags = "role",produces = "application/json")
    @RequestMapping(method = GET)
    public ResponseEntity<DataResult<PageInfo<Role>>> getRoles(@RequestParam(value = "index",defaultValue = "1") Integer index,
                                                               @RequestParam(value = "size",defaultValue = "100") Integer size){
        List<Role> roles = roleService.findNormalRoles(index, size);
        if(roles != null && roles.size() != 0){
            return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>((PageList<Role>) roles));
        }
        return ResultUtil.build(ErrorCode.ROLE_NOT_FOUND);
    }

    @ApiOperation(value = "获取角色信息",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}",method = GET)
    public ResponseEntity<DataResult<Role>> getRole(@PathVariable("roleId") Integer roleId){
        Role role = roleService.findRoleById(roleId);
        if(role != null){
            return ResultUtil.build(ErrorCode.SUCCESS,role);
        }
        return ResultUtil.build(ErrorCode.ROLE_NOT_FOUND);
    }
    @ApiOperation(value = "更新角色信息",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}",method = PATCH)
    public ResponseEntity<DataResult<Role>> updateRole(@PathVariable("roleId") Integer roleId,
                                                       @RequestBody RoleForm form){
        Role role = new Role(form);
        role.setId(roleId);
        try {
            role = roleService.updateByRole(role);
            return ResultUtil.build(ErrorCode.SUCCESS,role);
        } catch (RoleNotFoundException e) {
            return ResultUtil.build(ErrorCode.ROLE_NOT_FOUND);
        } catch (RoleExistException e) {
            return ResultUtil.build(ErrorCode.ROLE_EXIST);
        }
    }
    @ApiOperation(value = "角色停用",tags = "role",produces = "application/json")
    @RequestMapping(value = "/{roleId}",method = DELETE)
    public ResponseEntity deleteRole(@PathVariable("roleId") Integer roleId){
       roleService.deleteRole(roleId);
       return ResultUtil.build(ErrorCode.SUCCESS);
    }

}
