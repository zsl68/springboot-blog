package com.zsl.blog.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 张世林
 * @Date: 2020/12/7 14:57
 * @Description: 类型
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_type")
public class Type {

    @TableId
    private String id;

    private String name;

    @TableField(exist = false)
    private List<Blog> blogs;
}
