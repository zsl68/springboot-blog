package com.zsl.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 张世林
 * @Date: 2020/12/9 10:19
 * @Description: 博客
 * @Version 1.0
 */
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> queryPage(PageVo blogPageVo);

    List<Blog> newestBlog();
}
