package com.believe.sun.user.service;

import com.believe.sun.user.form.UserForm;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by sungj on 17-6-6.
 */
public interface UserService {

    User createUser(User user);

    User findUser(User user);

    List<Permission> findRoles(String username);

    List<Permission> findPermissions(String username);

    User findByUsername(String username);
}
