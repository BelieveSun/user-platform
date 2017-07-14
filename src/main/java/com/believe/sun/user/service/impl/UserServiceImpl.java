package com.believe.sun.user.service.impl;

import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.mapper.UserMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.User;
import com.believe.sun.user.model.UserExample;
import com.believe.sun.user.service.RoleService;
import com.believe.sun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sungj on 17-6-20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;


    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User findUser(User user) {
        return null;
    }

    @Override
    public List<Permission> findRoles(String username) {
        return null;
    }

    @Override
    public List<Permission> findPermissions(String account) {
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(example);
        if(users != null && users.size() > 0){
            User user = users.get(0);
            String roles = user.getRoles();
            String [] strRoleIds  = roles.split(",");
            List<Integer> roleIds = new ArrayList<>();
            for(String strRoleId :strRoleIds ){
                if(!roleIds.contains(Integer.valueOf(strRoleId))){
                    roleIds.add(Integer.valueOf(strRoleId));
                }
            }
            return roleService.findPermissionByRoleIds(roleIds);
        }

        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
