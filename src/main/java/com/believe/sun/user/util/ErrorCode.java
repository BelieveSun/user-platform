package com.believe.sun.user.util;

/**
 * Created by sungj on 17-7-26.
 */
public enum ErrorCode implements Error {

    LOGIN_FAILED                     (2001,"login failed !","账户或密码错误！请重新输入！"),
    AUTH_FAILED                      (2002,"auth failed !","登录失败！请稍后再试"),
    USER_ACCOUNT_EXIST               (2003,"user account is exist !","用户账户已存在！"),
    USER_CELLPHONE_EXIST             (2004,"user cellphone is exist !","用户手机号已存在！"),
    USER_EMAIL_EXIST                 (2005,"user email is exist !","用户邮箱已存在！"),
    PERMISSION_NAME_EXIST            (2006,"permission name is exist !","权限名已存在 ！"),
    PERMISSION_DELETE_FAILED         (2007,"permission delete failed !","权限删除失败！请检查权限状态！"),
    PERMISSION_NOT_FOUND             (2008,"permission not found !","权限未找到 ！" ),
    ROLE_EXIST                       (2009,"role is exist !","角色已存在！" ),
    ROLE_NOT_FOUND                   (2010,"role not found !","角色不存在！" ),
    USER_NOT_FOUND                   (2011,"user not found !","用户不存在！" );


    private Integer error;
    private String message;
    private String comment;

    ErrorCode(Integer error, String message) {
        this.error = error;
        this.message = message;
    }

    ErrorCode(Integer error, String message, String comment) {
        this.error = error;
        this.message = message;
        this.comment = comment;
    }

    @Override
    public Integer getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getComment() {
        return comment;
    }


}
