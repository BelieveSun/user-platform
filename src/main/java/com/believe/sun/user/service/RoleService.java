package com.believe.sun.user.service;

import com.believe.sun.user.model.Permission;

import java.util.List;

/**
 * Created by sungj on 17-7-14.
 */
public interface RoleService {

    List<Permission> findPermissionByRole(List<String> roles);
    List<Permission> findPermissionByRoleIds(List<Integer> roleIds);
}
