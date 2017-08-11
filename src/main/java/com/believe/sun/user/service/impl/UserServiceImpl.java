package com.believe.sun.user.service.impl;

import com.believe.sun.user.mapper.UserMapper;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.User;
import com.believe.sun.user.model.UserExample;
import com.believe.sun.user.service.RoleService;
import com.believe.sun.user.service.UserService;
import com.believe.sun.user.util.Error;
import com.believe.sun.user.util.ErrorCode;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungj on 17-6-20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public User createUser(User user) {
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    public Error exist(User user) {
        if(user != null){
            User existUser = findUserByAccount(user.getAccount());
            if(existUser != null) return ErrorCode.USER_ACCOUNT_EXIST;
            existUser = findUserByCellphone(user.getCellphone());
            if(existUser != null) return ErrorCode.USER_CELLPHONE_EXIST;
            existUser = findUserByEmail(user.getEmail());
            return existUser != null ? ErrorCode.USER_EMAIL_EXIST : null;
        }
        return null;
    }

    @Override
    public User auth(User user) {
        String userPassword = user.getPassword();
        String account = user.getAccount();
        User serverUser = findUserByAccount(account);
        String serverPassword = serverUser.getPassword();
        if(userPassword.equals(DigestUtils.md5Hex(serverPassword))){
            return serverUser;
        }
        return null;
    }

    @Override
    public User findUserByAccount(String account){
        if(account != null){
            UserExample example = new UserExample();
            example.createCriteria().andAccountEqualTo(account).andStatusEqualTo(0);
            List<User> users = userMapper.selectByExample(example);
            if(users != null && users.size() > 0){
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public User findUserByCellphone(String cellphone) {
        if(cellphone != null){
            UserExample example = new UserExample();
            example.createCriteria().andCellphoneEqualTo(cellphone).andStatusEqualTo(0);
            List<User> users = userMapper.selectByExample(example);
            if(users != null && users.size() > 0){
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        if(email != null){
            UserExample example = new UserExample();
            example.createCriteria().andEmailEqualTo(email).andStatusEqualTo(0);
            List<User> users = userMapper.selectByExample(example);
            if(users != null && users.size() > 0){
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Permission> findRoles(String username) {
        return null;
    }

    @Override
    public List<Permission> findPermissions(String account) {
            User user = findUserByAccount(account);
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

    @Override
    public List<User> findAllUser(Integer status,Integer index,Integer size) {
        if(status != null){
            return userMapper.selectByStatus(status,new PageBounds(index,size));
        }
        return userMapper.selectAll(new PageBounds(index, size));
    }

}
