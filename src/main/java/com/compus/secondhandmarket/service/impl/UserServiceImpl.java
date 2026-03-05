package com.compus.secondhandmarket.service.impl;

import com.compus.secondhandmarket.dto.LoginRequest;
import com.compus.secondhandmarket.dto.RegisterRequest;
import com.compus.secondhandmarket.entity.User;
import com.compus.secondhandmarket.mapper.UserMapper;
import com.compus.secondhandmarket.service.UserService;
import com.compus.secondhandmarket.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginRequest request) {
        User user = userMapper.findByStudentId(request.getStudentId());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        if (!user.getRole().equals(request.getRole())) {
            throw new RuntimeException("角色选择错误");
        }
        return user;
    }

    @Override
    public User register(RegisterRequest request) {
        // 检查学号是否已注册
        int count = userMapper.countByStudentId(request.getStudentId());
        if (count > 0) {
            throw new RuntimeException("该学号已注册");
        }

        User user = new User();
        BeanUtils.copyProperties(request, user);
        user.setCreditScore(100);  // 初始信用分

        userMapper.insert(user);
        return user;
    }

    @Override
    public UserVO getUserInfo(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.update(user) > 0;
    }
}