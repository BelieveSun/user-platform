package com.believe.sun.user.service.impl;

import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.User;
import com.believe.sun.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by sungj on 17-6-20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public User creatUser(User user) {
        return null;
    }

    @Override
    public User findUser(User user) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
