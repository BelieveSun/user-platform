package com.believe.sun.user.service;

import com.believe.sun.user.exception.PermissionExistException;
import com.believe.sun.user.exception.PermissionNotFoundException;
import com.believe.sun.user.model.Permission;

import java.util.List;
import java.util.Set;

/**
 * Created by sungj on 17-7-14.
 */
public interface PermissionService {
    List<Permission> findPermissionByIds(List<Integer> permissionIds);

    Permission createPermission(Permission permission) throws PermissionExistException;

    void deletePermission(Integer permissionId);

    List<Permission> findNormalPermissions(Integer index, Integer size);

    Permission findPermissionById(Integer permissionId);

    Permission updatePermission(Permission permission) throws PermissionNotFoundException;
}
