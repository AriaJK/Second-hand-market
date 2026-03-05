package com.compus.secondhandmarket.controller;

import com.compus.secondhandmarket.common.ApiResponse;
import com.compus.secondhandmarket.dto.LoginRequest;
import com.compus.secondhandmarket.dto.RegisterRequest;
import com.compus.secondhandmarket.entity.User;
import com.compus.secondhandmarket.service.UserService;
import com.compus.secondhandmarket.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ApiResponse<User> login(@RequestBody LoginRequest request, HttpSession session) {
        User user = userService.login(request);
        // 将用户信息存入session
        session.setAttribute("userId", user.getId());
        session.setAttribute("userRole", user.getRole());
        return ApiResponse.success(user);
    }

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return ApiResponse.success(user);
    }

    @GetMapping("/logout")
    public ApiResponse<Void> logout(HttpSession session) {
        session.invalidate();
        return ApiResponse.success(null);
    }

    @GetMapping("/info")
    public ApiResponse<UserVO> getUserInfo(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ApiResponse.error(401, "未登录");
        }
        UserVO userVO = userService.getUserInfo(userId);
        return ApiResponse.success(userVO);
    }
}