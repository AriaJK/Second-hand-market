package com.compus.secondhandmarket.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String studentId;    // 学号
    private String username;     // 用户名
    private String password;     // 密码
    private String phone;        // 手机号
    private Integer role = 1;    // 默认注册为买家
}