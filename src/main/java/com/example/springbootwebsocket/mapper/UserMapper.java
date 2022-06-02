package com.example.springbootwebsocket.mapper;

import com.example.springbootwebsocket.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-06-01
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserByUserName(@Param("username") String username);

    User getUserById(@Param("userId") String userId);

}
