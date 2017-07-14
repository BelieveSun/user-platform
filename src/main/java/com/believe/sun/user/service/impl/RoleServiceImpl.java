package com.believe.sun.user.service.impl;

import com.believe.sun.user.mapper.PermissionMapper;
import com.believe.sun.user.mapper.RoleMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.PermissionExample;
import com.believe.sun.user.model.Role;
import com.believe.sun.user.model.RoleExample;
import com.believe.sun.user.service.PermissionService;
import com.believe.sun.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungj on 17-7-14.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionService permissionService;

    @Override
    public List<Permission> findPermissionByRole(List<String> roleNames) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIn(roleNames);
        List<Role> roles = roleMapper.selectByExample(roleExample);
       return permissionService.findPermissionByIds(getPermissionIds(roles));
    }

    @Override
    public List<Permission> findPermissionByRoleIds(List<Integer> roleIds) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIn(roleIds);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return permissionService.findPermissionByIds(getPermissionIds(roles));
    }


    private List<Integer> getPermissionIds(List<Role> roles){
        List<Integer> permissionIds = new ArrayList<>();
        for (Role r : roles){
            for (String permissionId :r.getPermissionId().split(",")){
                if(!permissionIds.contains(Integer.valueOf(permissionId))){
                    permissionIds.add(Integer.valueOf(permissionId));
                }
            }
        }
        return permissionIds;
    }
}
