package com.example.springbootwebsocket.service.impl;

import com.example.springbootwebsocket.model.entity.User;
import com.example.springbootwebsocket.mapper.UserMapper;
import com.example.springbootwebsocket.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-06-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
