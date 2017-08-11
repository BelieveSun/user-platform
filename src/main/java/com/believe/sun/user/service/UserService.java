package com.believe.sun.user.service;

import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.User;
import com.believe.sun.user.util.Error;

import java.util.List;

/**
 * Created by sungj on 17-6-6.
 */
public interface UserService {

    User createUser(User user);

    Error exist(User user);

    User auth(User user);

    User findUserByAccount(String account);

    User findUserByCellphone(String cellphone);

    User findUserByEmail(String email);

    List<Permission> findRoles(String username);

    List<Permission> findPermissions(String username);

    List<User> findAllUser(Integer status,Integer index,Integer size);
}
