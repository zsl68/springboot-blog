package com.zsl.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsl.blog.model.User;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:14
 * @Description:
 * @Version 1.0
 */
public interface UserService extends IService<User> {


    User getUser(String name);

    User queryDemo();
}
