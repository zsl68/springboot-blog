package com.zsl.blog.controller;

import com.zsl.blog.common.PageVo;
import com.zsl.blog.common.ResultData;
import com.zsl.blog.model.Type;
import com.zsl.blog.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/8 15:41
 * @Description: 类型控制器
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/type")
public class TypeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TypeService typeService;

    @PostMapping("/page")
    public Object queryPage(PageVo vo){
        Map<String, Object> map = typeService.queryPage(vo);
        return  map;
    }

    @PostMapping("/save")
    public ResultData save(@RequestBody Type type){
        try {
            typeService.saveOrUpdate(type);
            return ResultData.success();
        }catch (RuntimeException e){
            return ResultData.error();
        }
    }

    @RequestMapping("/del")
    public ResultData del(String id){
        try {
            typeService.removeById(id);
            return ResultData.success();
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResultData.error().message(e.getMessage());
        }
    }

    @GetMapping("/typeCount")
    public ResultData typeCount(){
       return ResultData.success().data("data",typeService.findTypeCount());
    }
}
