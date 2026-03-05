package com.compus.secondhandmarket.service;

import com.compus.secondhandmarket.dto.LoginRequest;
import com.compus.secondhandmarket.dto.RegisterRequest;
import com.compus.secondhandmarket.entity.User;
import com.compus.secondhandmarket.vo.UserVO;

public interface UserService {
    User login(LoginRequest request);
    User register(RegisterRequest request);
    UserVO getUserInfo(Long userId);
    boolean updateUser(User user);
}