package com.zsl.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:05
 * @Description: 用户
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_user")
public class User {

    @TableId(type= IdType.AUTO)
    private String userId;

    private String userName;

    private String email;

    private String iphone;

    private String password;

    @TableField("head_portrait")
    private String headPortrait;

    @TableField(exist = false)
    private Test test;
}
