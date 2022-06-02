package com.example.springbootwebsocket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootwebsocket.model.entity.User;
import com.example.springbootwebsocket.service.LoginService;
import com.example.springbootwebsocket.webSocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: chenchong
 * @Date: 2022/6/2 15:36
 */
@Controller
public class ChatController {
    @Resource
    private LoginService loginservice;


    @RequestMapping("/onlineUsers")
    @ResponseBody
    public Set<String> onlineusers(@RequestParam("currentUser") String currentuser) {
        ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        Set<String> nameset = new HashSet<String>();
        while (it.hasNext()) {
            String entry = it.next();
            if (!entry.equals(currentuser))
                nameset.add(entry);
        }
        return nameset;
    }


    @RequestMapping("getuid")
    @ResponseBody
    public User getuid(@RequestParam("username") String username) {
        User user = loginservice.getUserByUserName(username);
        return user;
    }

    /**
     * 发送数据给指定用户
     * @param to
     * @param message
     * @return
     */
    @GetMapping("sendMessage")
    @ResponseBody
    public String sendMessage(@RequestParam("to")String to,@RequestParam("message") String message) {
        JSONObject object = new JSONObject();
        object.put("to",to);
        object.put("text",message);
        object.put("date", LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        object.put("from","系统");
        WebSocketServer webSocketServer = new WebSocketServer();
        webSocketServer.sendInfo(to, object.toJSONString());

        return "success";
    }
}
