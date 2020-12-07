package com.zsl.blog.controller;

import com.zsl.blog.model.User;
import com.zsl.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 13:51
 * @Description:
 * @Version 1.0
 */
@Controller
@RequestMapping("/system/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(String nameorIphone, String password){
        User user = userService.getUserByName(nameorIphone);
        User user1 = userService.queryDemo();
        do{

        }while(user!=null);
        return "";
    }
}
