package com.example.springbootwebsocket.controller;


import com.example.springbootwebsocket.common.reponse.BaseResult;
import com.example.springbootwebsocket.model.entity.User;
import com.example.springbootwebsocket.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-06-01
 */
@Controller
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 登录验证
     * @param username
     * @param password
     * @param httpSession
     * @return
     */
    @PostMapping("/loginValidate")
    public String login(String username, String password, HttpSession httpSession) {
        if(username == null){
            return "login";
        }
        //根据用户名获取用户密码
        User user = loginService.getUserByUserName(username);
        if(user.getPassword() != null && user.getPassword().equals(password)){
            //将用户id放进session中
            httpSession.setAttribute("uid",user.getId());
            return "chatroom";

        }else{
            return "fail";
        }

    }

    /**
     * 获取当前的用户信息
     * @return
     */
    @GetMapping("/currentUser")
    @ResponseBody
    public User currentUser(HttpSession session){
        String uid = (String) session.getAttribute("uid");
        User user = loginService.getUserById(uid);
        return user;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        return "login";
    }

}

