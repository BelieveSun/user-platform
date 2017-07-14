package com.believe.sun.user.service;

import com.believe.sun.user.model.Permission;

import java.util.List;
import java.util.Set;

/**
 * Created by sungj on 17-7-14.
 */
public interface PermissionService {
    List<Permission> findPermissionByIds(List<Integer> permissionIds);
}
