package com.believe.sun.user.service.impl;

import com.believe.sun.user.mapper.PermissionMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.PermissionExample;
import com.believe.sun.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        example.createCriteria().andIdIn(permissionIds);
        return permissionMapper.selectByExample(example);

    }
}
