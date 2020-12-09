package com.zsl.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/9 10:21
 * @Description:
 * @Version 1.0
 */
public interface BlogService extends IService<Blog> {

    Map<String,Object> queryPage(PageVo blogPageVo);

    List<Blog> newestBlog();
}
