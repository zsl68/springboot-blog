package com.zsl.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsl.blog.model.Type;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/8 15:43
 * @Description:
 * @Version 1.0
 */
@Repository
public interface TypeMapper extends BaseMapper<Type> {
    List<Map<String,Object>> findTypeCount();
}
