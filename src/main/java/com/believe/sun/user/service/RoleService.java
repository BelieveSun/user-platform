package com.believe.sun.user.service;

import com.believe.sun.user.exception.RoleExistException;
import com.believe.sun.user.exception.RoleNotFoundException;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.Role;

import java.util.List;

/**
 * Created by sungj on 17-7-14.
 */
public interface RoleService {

    List<Permission> findPermissionByRole(List<String> roles);
    List<Permission> findPermissionByRoleIds(List<Integer> roleIds);

    Role createRole(Role role) throws RoleExistException;

    Role findRoleById(Integer id);

    List<Role> findNormalRoles(Integer index, Integer size);

    Role updateByRole(Role role) throws RoleNotFoundException, RoleExistException;

    void deleteRole(Integer roleId);

    Role addPermission(Role role);

    Role deletePermission(Role role);

    List<Role> findRolesByIds(List<Integer> ids);
}
