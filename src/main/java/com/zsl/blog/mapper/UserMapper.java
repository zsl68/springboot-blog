package com.zsl.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsl.blog.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:14
 * @Description:
 * @Version 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

   User queryDemo();
}
