package com.believe.sun.user.service.impl;

import com.believe.sun.user.mapper.UserMapper;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungj on 17-6-6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User creatUser(User user) {

        userMapper.insertSelective(user);
        return user;
    }
}
