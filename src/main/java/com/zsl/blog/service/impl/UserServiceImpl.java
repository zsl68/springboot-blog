package com.zsl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsl.blog.mapper.UserMapper;
import com.zsl.blog.model.User;
import com.zsl.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:15
 * @Description:
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String nameOrIphone) {
        return userMapper.selectOne(new QueryWrapper<User>()
                .eq("userName",nameOrIphone)
                .or()
                .eq("iphone",nameOrIphone));
    }

    @Override
    public User queryDemo() {
        return userMapper.queryDemo();
    }
}
