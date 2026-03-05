package com.compus.secondhandmarket.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String studentId;    // 学号
    private String password;     // 密码
    private Integer role;        // 角色：1-买家 2-卖家 3-管理员
}