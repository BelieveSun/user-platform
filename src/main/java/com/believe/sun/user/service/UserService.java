package com.believe.sun.user.service;

import com.believe.sun.tool.Error;
import com.believe.sun.user.exception.UserNotFoundException;
import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.Role;
import com.believe.sun.user.model.User;

import java.util.List;

/**
 * Created by sungj on 17-6-6.
 */
public interface UserService {

    User createUser(User user);

    Error exist(User user);

    User auth(User user) throws UserNotFoundException;

    User findUserByAccount(String account);

    User findUserByCellphone(String cellphone);

    User findUserByEmail(String email);

    List<Role> findRoles(User user);

    List<Permission> findPermissions(User user);

    List<User> findAllUser(Integer status,Integer index,Integer size);

    User findUserById(Integer userId);
}
