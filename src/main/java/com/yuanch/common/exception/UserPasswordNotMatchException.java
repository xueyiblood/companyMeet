package com.yuanch.common.exception;

/**
 * 用户密码不正确或不符合规范异常类
 *
 * @author sj
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
