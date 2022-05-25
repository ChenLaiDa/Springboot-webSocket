package com.example.springbootwebsocket.controller;


import com.example.springbootwebsocket.common.reponse.BaseResult;
import com.example.springbootwebsocket.model.entity.WebsocketUser;
import com.example.springbootwebsocket.service.IWebsocketUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-05-25
 */
@RestController
@RequestMapping("/websocket-user")
@Api(tags = "用户管理")
public class WebsocketUserController {
    @Resource
    private IWebsocketUserService websocketUserService;

    @ApiOperation("添加用户")
    @PostMapping("/saveUser")
    public BaseResult<?> saveUser(@RequestBody WebsocketUser user){
        user.setCreateTime(LocalDateTime.now());
        websocketUserService.save(user);
        return BaseResult.success("添加成功!");
    }


}

