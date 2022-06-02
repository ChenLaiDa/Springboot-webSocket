package com.example.springbootwebsocket.service;

import com.example.springbootwebsocket.model.entity.User;

/**
 * @Description:
 * @Author: chenchong
 * @Date: 2022/6/2 14:47
 */
public interface LoginService {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
    /**
     * 根据用户id获取用户信息
     */
    User getUserById(String userId);
}
