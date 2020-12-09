package com.zsl.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:05
 * @Description: 用户
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class User {

    @TableId(value = "id")
    private String userId;

    private String username;

    private String nickname;

    private String email;

    private String iphone;

    private Integer type;

    private String password;

    @TableField("type_id")
    private String typeId;

    @TableField(exist = false)
    private List<Blog> blogs = Lists.newArrayList();

    /*创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /*修改时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField("update_time")
    private Date updateTime;

}
