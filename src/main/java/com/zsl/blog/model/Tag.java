package com.zsl.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 张世林
 * @Date: 2020/12/6 7:10
 * @Description:
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_tag")
public class Tag {

    @TableId(type = IdType.AUTO)
    private String id;

    private String name;

    private List<Blog> blogs = Lists.newArrayList();
}
