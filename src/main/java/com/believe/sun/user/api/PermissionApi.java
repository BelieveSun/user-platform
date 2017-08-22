package com.believe.sun.user.api;

import com.believe.sun.tool.DataResult;
import com.believe.sun.tool.PageInfo;
import com.believe.sun.tool.ResultUtil;
import com.believe.sun.user.exception.PermissionExistException;
import com.believe.sun.user.exception.PermissionNotFoundException;
import com.believe.sun.user.form.PermissionForm;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.service.PermissionService;
import com.believe.sun.user.util.ErrorCode;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sungj on 17-7-28.
 */
@RestController
@RequestMapping("/permissions")
public class PermissionApi {
    private static final Logger logger = LoggerFactory.getLogger(PermissionApi.class);

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "权限列表", tags = "permission", produces = "application/json")
    @RequestMapping(method = GET)
    public ResponseEntity<DataResult<PageInfo<Permission>>> getPermissions(@ApiParam("页码,默认为1") @RequestParam(value = "index", defaultValue = "1") Integer index,
                                                                           @ApiParam("一页大小,默认为100") @RequestParam(value = "size", defaultValue = "100") Integer size) {
        List<Permission> normalPermissions = permissionService.findNormalPermissions(index, size);
        if (normalPermissions == null || normalPermissions.size() == 0) {
            //没有正常的权限
            return ResultUtil.build(ErrorCode.SERVICE_INNER_ERROR);
        }
        PageList<Permission> pageList = (PageList<Permission>) normalPermissions;

        return ResultUtil.build(ErrorCode.SUCCESS, new PageInfo<>(pageList));

    }

    @ApiOperation(value = "创建权限", tags = "permission", produces = "application/json")
    @RequestMapping(value = "", method = POST)
    public ResponseEntity<DataResult<Permission>> createPermission(@Validated @RequestBody PermissionForm form) {
        Permission permission;
        try {
            permission = permissionService.createPermission(new Permission(form));
        } catch (PermissionExistException e) {
            logger.info("permission name : {} is exist !", form.getName());
            return ResultUtil.build(ErrorCode.PERMISSION_NAME_EXIST);
        }
        return ResultUtil.build(ErrorCode.SUCCESS, permission);
    }

    @ApiOperation(value = "获取权限信息", tags = "permission", produces = "application/json")
    @RequestMapping(value = "/{permissionId}", method = GET)
    public ResponseEntity<DataResult<Permission>> getPermission(@PathVariable("permissionId") Integer permissionId) {
        Permission permission = permissionService.findPermissionById(permissionId);
        if (permission == null) {
            return ResultUtil.build(ErrorCode.PERMISSION_NOT_FOUND);
        }
        return ResultUtil.build(ErrorCode.SUCCESS, permission);
    }

    @ApiOperation(value = "更新权限信息", tags = "permission", produces = "application/json")
    @RequestMapping(value = "/{permissionId}", method = PATCH)
    public ResponseEntity<DataResult<Permission>> updatePermission(@ApiParam("权限Id") @PathVariable("permissionId") Integer permissionId,
                                                                   @RequestBody PermissionForm form) {
        Permission permission = new Permission(form);
        permission.setId(permissionId);
        try {
            permission = permissionService.updatePermission(permission);
            return ResultUtil.build(ErrorCode.SUCCESS, permission);
        } catch (PermissionNotFoundException e) {
            return ResultUtil.build(ErrorCode.PERMISSION_NOT_FOUND);
        } catch (PermissionExistException e) {
            return ResultUtil.build(ErrorCode.PERMISSION_NAME_EXIST);
        }
    }

    @ApiOperation(value = "删除权限", tags = "permission", produces = "application/json")
    @RequestMapping(value = "/{permissionId}", method = DELETE)
    public ResponseEntity deletePermission(@PathVariable("permissionId") Integer permissionId) {
        permissionService.deletePermission(permissionId);
        return ResultUtil.build(ErrorCode.SUCCESS);
    }
}
