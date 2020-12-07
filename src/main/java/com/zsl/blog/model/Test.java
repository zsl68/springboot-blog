package com.zsl.blog.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张世林
 * @Date: 2020/12/6 7:10
 * @Description:
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_test")
public class Test {

    @TableId
    private String id;

    private String name;
}
