package com.compus.secondhandmarket.controller;

import com.compus.secondhandmarket.common.ApiResponse;
import com.compus.secondhandmarket.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public ApiResponse<String> hello() {
        return ApiResponse.success("后端服务运行正常！当前时间：" + new java.util.Date());
    }

    @GetMapping("/db")
    public ApiResponse<String> testDB() {
        try {
            int count = userMapper.countByStudentId("test");
            return ApiResponse.success("数据库连接成功！用户表可正常查询");
        } catch (Exception e) {
            return ApiResponse.error("数据库连接失败：" + e.getMessage());
        }
    }
}