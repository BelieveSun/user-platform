package com.believe.sun.user.service;

/**
 * Created by sungj on 17-7-11.
 */
public interface AuthenticationService {
    String requestToken(String principal,String credentials,String grantType);

    String validateToken(String token);
}
