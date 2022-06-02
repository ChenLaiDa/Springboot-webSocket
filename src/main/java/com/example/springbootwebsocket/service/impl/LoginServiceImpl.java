package com.example.springbootwebsocket.service.impl;

import com.example.springbootwebsocket.mapper.UserMapper;
import com.example.springbootwebsocket.model.entity.User;
import com.example.springbootwebsocket.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chenchong
 * @Date: 2022/6/2 14:47
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.getUserByUserName(userName);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }
}
