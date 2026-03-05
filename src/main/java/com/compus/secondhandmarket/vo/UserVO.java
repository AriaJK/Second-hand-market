package com.compus.secondhandmarket.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String studentId;
    private String username;
    private Integer role;
    private String avatar;
    private String phone;
    private Integer creditScore;
}