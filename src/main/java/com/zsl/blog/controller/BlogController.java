package com.zsl.blog.controller;

import com.zsl.blog.common.PageVo;
import com.zsl.blog.common.ResultData;
import com.zsl.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 张世林
 * @Date: 2020/12/9 10:20
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/page")
    public ResultData page(@RequestBody PageVo pageVo){

        return ResultData.success().data(blogService.queryPage(pageVo));
    }

    @GetMapping("/newestBlog")
    public ResultData newestBlog(){
        return ResultData.success().data("data",blogService.newestBlog());
    }
}
