package com.til;

public interface MessageType {

    String message_login_success = "1";//登陆成功
    String message_login_failed_password_error = "2";//登录失败,密码错误
    String message_login_failed_none_error = "3";//登录失败,账户不存在
    String message_register_success = "4";//注册成功
    String message_register_failed = "5";//注册失败

}
