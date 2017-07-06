package com.believe.sun.user.service;

import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.User;

import java.util.Set;

/**
 * Created by sungj on 17-6-6.
 */
public interface UserService {

    User creatUser(User user);

    User findUser(User user);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    User findByUsername(String username);
}
