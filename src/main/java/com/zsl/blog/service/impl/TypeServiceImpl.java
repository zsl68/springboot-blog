package com.zsl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.mapper.TypeMapper;
import com.zsl.blog.model.Type;
import com.zsl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/8 15:45
 * @Description:
 * @Version 1.0
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public void saveType(Type type) {
        Type types = typeMapper.selectOne(new QueryWrapper<Type>().eq("name", type.getName()));

        if(null != types){

        }
        typeMapper.insert(type);
    }

    @Override
    public Map<String, Object> queryPage(PageVo vo) {
//        PageHelper.startPage(vo.getOffset(), vo.getLimit());
        QueryWrapper<Type> queryWrapper = new QueryWrapper<>();
        Map<String,Object> map = Maps.newHashMap();

//        String title = vo.getT().getTitle();
//        if(StringUtils.isNotBlank(title)){
//            queryWrapper.likeLeft("title",title);
//        }
//
//        String typeName = vo.getT().getType().getName();
//        if(StringUtils.isNotBlank(typeName)){
//            queryWrapper.eq("type_id",typeName);
//        }
        List<Type> typeList = typeMapper.selectList(queryWrapper);
        map.put("rows",typeList);
        map.put("total",typeList.size());
        return map;
    }

    @Override
    public List<Map<String,Object>> findTypeCount() {
        return typeMapper.findTypeCount();
    }
}
