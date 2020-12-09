package com.zsl.blog.controller;

import com.zsl.blog.common.ResultData;
import com.zsl.blog.model.User;
import com.zsl.blog.service.UserService;
import com.zsl.blog.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 13:51
 * @Description:
 * @Version 1.0
 */
@Controller
@RequestMapping("/system/admin")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/login")
    public String login(@RequestParam String nameOrIphone,
                        @RequestParam String password,
                        RedirectAttributes attributes){
        User user = userService.getUser(nameOrIphone);
        String md5Password = Md5Utils.string2Md5(password);
        if(null != user){
            if(md5Password.equals(user.getPassword())){
                request.getSession().setAttribute("user",user);
                return "admin/blogs";
            }
        }else {
            return "admin/login";
        }

        return null;
    }

    @GetMapping("/list")
    public void list(){
        System.out.println("123");
    }
}
