package com.example.springbootwebsocket.service.impl;

import com.example.springbootwebsocket.model.entity.WebsocketUser;
import com.example.springbootwebsocket.mapper.WebsocketUserMapper;
import com.example.springbootwebsocket.service.IWebsocketUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-05-25
 */
@Service
public class WebsocketUserServiceImpl extends ServiceImpl<WebsocketUserMapper, WebsocketUser> implements IWebsocketUserService {

}
