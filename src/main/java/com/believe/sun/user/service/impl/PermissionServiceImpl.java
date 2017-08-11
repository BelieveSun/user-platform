package com.believe.sun.user.service.impl;

import com.believe.sun.user.exception.PermissionExistException;
import com.believe.sun.user.exception.PermissionNotFoundException;
import com.believe.sun.user.mapper.PermissionMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.PermissionExample;
import com.believe.sun.user.service.PermissionService;
import com.believe.sun.user.util.Constants;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by sungj on 17-7-14.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionByIds(List<Integer> permissionIds) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andIdIn(permissionIds).andStatusEqualTo(Constants.NORMAL);
        return permissionMapper.selectByExample(example);

    }

    @Override
    public Permission createPermission(Permission permission) throws PermissionExistException {
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(permission.getName());
        List<Permission> permissions = permissionMapper.selectByExample(example);
        if(permissions != null && permissions.size() != 0){
            throw new PermissionExistException();
        }
        permissionMapper.insertSelective(permission);
        return permission;
    }

    @Override
    public void deletePermission(Integer permissionId) {
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        if(permission != null && !Objects.equals(permission.getStatus(), Constants.STOP)){
            permission.setStatus(Constants.STOP);
            permissionMapper.updateByPrimaryKeySelective(permission);
        }
    }

    @Override
    public List<Permission> findNormalPermissions(Integer index, Integer size) {
        return permissionMapper.selectByStatus(Constants.NORMAL, new PageBounds(index,size));
    }

    @Override
    public Permission findPermissionById(Integer permissionId) {
        List<Integer> permissionIds = new ArrayList<>();
        permissionIds.add(permissionId);
        List<Permission> permissions = findPermissionByIds(permissionIds);
        if(permissions != null && permissions.size() > 0){
            return permissions.get(0);
        }
        return null;
    }

    @Override
    public Permission updatePermission(Permission permission) throws PermissionNotFoundException {
        int i = permissionMapper.updateByPrimaryKeySelective(permission);
        if(i == 0){
            Permission olePermission = permissionMapper.selectByPrimaryKey(permission.getId());
            if(olePermission == null) {
                throw new PermissionNotFoundException();
            }
        }
        return permission;
    }
}
