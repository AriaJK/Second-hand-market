package com.compus.secondhandmarket.entity;

import lombok.Data;

// dto/RegisterRequest.java
@Data
public class RegisterRequest {
    private String studentId;
    private String username;
    private String password;
    private String phone;
    private Integer role = 1; // 默认注册为买家
}
