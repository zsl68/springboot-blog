package com.zsl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.mapper.BlogMapper;
import com.zsl.blog.model.Blog;
import com.zsl.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/9 10:21
 * @Description:
 * @Version 1.0
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
        implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Map<String,Object> queryPage(PageVo blogPageVo) {
        Map<String,Object> map = Maps.newHashMap();
        List<Blog> blogs = blogMapper.queryPage(blogPageVo);
        map.put("rows",blogs);
        map.put("total",blogs.size());
        return map;
    }

    @Override
    public List<Blog> newestBlog() {
        return blogMapper.newestBlog();
    }
}
