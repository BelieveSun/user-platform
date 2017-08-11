package com.believe.sun.user.service.impl;

import com.believe.sun.user.exception.RoleExistException;
import com.believe.sun.user.exception.RoleNotFoundException;
import com.believe.sun.user.mapper.RoleMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.Role;
import com.believe.sun.user.model.RoleExample;
import com.believe.sun.user.service.PermissionService;
import com.believe.sun.user.service.RoleService;
import com.believe.sun.user.util.Constants;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Role createRole(Role role) throws RoleExistException {
        Role oldRole = findRoleByRoleName(role.getRole());
        if(oldRole != null){
            throw new RoleExistException();
        }
        roleMapper.insertSelective(role);
        return role;
    }

    @Override
    public Role findRoleById(Integer id) {
        return null;
    }

    @Override
    public List<Role> findNormalRoles(Integer index, Integer size) {
        return roleMapper.selectByStatus(Constants.NORMAL, new PageBounds(index, size));
    }

    @Override
    public Role updateByRole(Role role) throws RoleNotFoundException {
//        if(permissionId != null) {
//            String oldPermissionId = oleRole.getPermissionId();
//            String[] split = StringUtils.split(oldPermissionId, ",");
//            HashSet<String> hashSet = new HashSet<>(Arrays.asList(split));
//            String[] permissions = StringUtils.split(permissionId, ",");
//            hashSet.addAll(Arrays.asList(permissions));
//            //add new permission
//            role.setPermissionId(StringUtils.join(hashSet,","));
//        }
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if(i == 0){
            Role oldRole = roleMapper.selectByPrimaryKey(role.getId());
            if(oldRole == null) throw new RoleNotFoundException();
        }
        return role;
    }

    @Override
    public void deleteRole(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if(role.getStatus() != Constants.STOP){
            role.setStatus(Constants.STOP);
            roleMapper.updateByPrimaryKeySelective(role);
        }
    }

    @Override
    public Role addPermission(Role role) {
        Role oldRole = findRoleById(role.getId());
        String permissionId = role.getPermissionId();
        if(permissionId != null) {
            String oldPermissionId = oldRole.getPermissionId();
            String[] split = StringUtils.split(oldPermissionId, ",");
            HashSet<String> hashSet = new HashSet<>(Arrays.asList(split));
            String[] permissions = StringUtils.split(permissionId, ",");
            hashSet.addAll(Arrays.asList(permissions));
            //add new permission
            oldRole.setPermissionId(StringUtils.join(hashSet,","));
            roleMapper.updateByPrimaryKeySelective(oldRole);
        }
        return oldRole;
    }

    @Override
    public Role deletePermission(Role role) {
        Role oldRole = findRoleById(role.getId());
        String permissionId = role.getPermissionId();
        if(permissionId != null){
            String oldPermissionId = oldRole.getPermissionId();
            String[] oldPermissionIds = StringUtils.split(oldPermissionId, ",");
            List<String> deletePermissionIds = Arrays.asList(StringUtils.split(permissionId, ","));
            Set<String> newPermissionIds = new HashSet<>();
            for(String permission : oldPermissionIds){
                if(deletePermissionIds.contains(permission)){
                    continue;
                }
                newPermissionIds.add(permission);
            }
            oldRole.setPermissionId(StringUtils.join(newPermissionIds,","));
            roleMapper.updateByPrimaryKeySelective(oldRole);
        }
        return oldRole;
    }

    public Role findRoleByRoleName(String role){
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleEqualTo(role);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        if(roles != null && roles.size() > 0){
            return roles.get(0);
        }
        return null;
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
