package com.compus.secondhandmarket.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String studentId;      // 学号
    private String username;       // 用户名
    private String password;       // 密码（明文）
    private Integer role;          // 角色：1-买家 2-卖家 3-管理员
    private String avatar;         // 头像
    private String phone;          // 手机号
    private String email;          // 邮箱
    private Integer status;        // 状态：1-正常 2-黑名单
    private LocalDateTime blacklistEndTime; // 黑名单结束时间
    private Integer warningCount;  // 警告次数
    private Integer creditScore;   // 信用分
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}