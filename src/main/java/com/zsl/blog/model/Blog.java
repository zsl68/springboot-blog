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
 * @Date: 2020/12/7 14:48
 * @Description: 博客
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_blog")
public class Blog {

    @TableId(type = IdType.AUTO)
    private String id;

    /*标题*/
    private String title;

    /*内容*/
    private String content;

    /*赞赏*/
    private String firstPicture;

    /**/
    private Integer flag;

    /*访问量*/
    private Integer views;

    /**/
    private boolean apprecitation;

    /*转载声明*/
    private boolean shareStatment;

    /*评论*/
    private boolean commenttabled;

    /*发布|草稿*/
    private boolean published;

    /*是否推荐*/
    private boolean recommend;

    /*创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /*修改时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    private Type type;

    private List<Tag> tags = Lists.newArrayList();

    private List<Comment> comments = Lists.newArrayList();
}
