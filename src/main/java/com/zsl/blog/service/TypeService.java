package com.zsl.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.model.Blog;
import com.zsl.blog.model.Type;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/8 15:44
 * @Description:
 * @Version 1.0
 */
public interface TypeService extends IService<Type> {

    Map<String,Object> queryPage(PageVo vo);

    void saveType(Type type);

    List<Map<String,Object>> findTypeCount();
}
