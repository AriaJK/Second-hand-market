package com.compus.secondhandmarket.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoginRequest {
    private String studentId;
    private String password;
    private Integer role; // 1-买家 2-卖家 3-管理员
}

