package com.zsl.blog.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.zsl.blog.common.PageVo;
import com.zsl.blog.common.ResultData;
import com.zsl.blog.model.SpecialOutputObject;
import com.zsl.blog.service.BlogService;
import com.zsl.blog.wordUtils.MDoc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @Author: 张世林
 * @Date: 2020/12/9 10:20
 * @Description:
 * @Version 1.0
 */
@Api("博客控制器")
@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /*JavaEmail*/
    @Autowired
    private JavaMailSender mailSender;

    @Value("spring.mail.username")
    private String sendPerson;

    @ApiOperation(value = "博客分页数据",httpMethod = "POST")
    @PostMapping("/page")
    public ResultData page(@ApiParam(name = "分页参数",required = true) @RequestBody PageVo pageVo){

        return ResultData.success().data(blogService.queryPage(pageVo));
    }

    @GetMapping("/newestBlog")
    public ResultData newestBlog(){
        return ResultData.success().data("data",blogService.newestBlog());
    }


    @GetMapping("/sql")
    public ResultData selectSql(String sql){
        List<Map> objects = blogService.selectSql(sql);
        return ResultData.success().data("data",objects);
    }

    @GetMapping("/blogPigeonhole")
    public ResultData blogPigeonhole(){
        return ResultData.success().data("result",blogService.blogsByYear());
    }

    @GetMapping("send")
    public void send(String email){
        Map<String,Object> freeMakerMap = Maps.newHashMap();
        String str = "{\"returnCode\":\"0\",\"beans\":[],\"resultCode\":\"\",\"returnMessage\":\"success\",\"bean\":{},\"object\":{\"total\":6,\"moduleType\":\"list\",\"dataList\":[[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"河南省源铄互联网产业发展基金(有限合伙)\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"12.698400\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"河南省源铄互联网产业发展基金(有限合伙)\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"12.6984\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"北京山谷创新资产管理有限公司\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"控股股东\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"47.48\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"北京山谷创新资产管理有限公司\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"控股股东\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"47.480000\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"谷晶中\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"3.563500\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"谷晶中\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"3.5635\"}]],\"moduleName\":\"参股控股\",\"titleInfo\":[{\"code\":\"serial\",\"attachInfo\":null,\"name\":\"序号\"},{\"code\":\"relAname\",\"attachInfo\":null,\"name\":\"关联方名称\"},{\"code\":\"relaTypeName\",\"attachInfo\":null,\"name\":\"关联关系\"},{\"code\":\"skrto\",\"attachInfo\":null,\"name\":\"占本公司股权比例\"}],\"pageSize\":10,\"pageNum\":1}}";
        SpecialOutputObject specialOutputObject = JSON.parseObject(str, SpecialOutputObject.class);
        freeMakerMap.put("data128",specialOutputObject);
        freeMakerMap.put("data065",selectJpxx());
        MDoc mdoc = new MDoc();
        try {
            mdoc.createDoc(freeMakerMap,"D:/outFile.doc");
            System.out.println("模板生成成功");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public  SpecialOutputObject selectJpxx(){
        String str = "{\"returnCode\":\"0\",\"beans\":[],\"resultCode\":\"\",\"returnMessage\":\"success\",\"bean\":{},\"object\":{\"total\":2,\"moduleType\":\"list\",\"dataList\":[[{\"code\":\"serial\",\"attachInfo\":{\"cessWidth\":\"50\"},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"product\",\"attachInfo\":{},\"name\":\"产品名称\",\"value\":\"凌久高科\"},{\"code\":\"finRounds\",\"attachInfo\":{},\"name\":\"当前融资轮次\",\"value\":\"-\"},{\"code\":\"crtTime\",\"attachInfo\":{},\"name\":\"成立日期\",\"value\":\"2008-09-01\"},{\"code\":\"productLabel\",\"attachInfo\":{},\"name\":\"产品标签\",\"value\":\"企业服务\"},{\"code\":\"affiliation\",\"attachInfo\":{},\"name\":\"所属地\",\"value\":\"湖北\"},{\"code\":\"introduce\",\"attachInfo\":{\"cessWidth\":\"500\"},\"name\":\"简介\",\"value\":\"中船重工（武汉）凌久高科有限公司是中国船舶重工集团公司第七〇九研究所为发展民品产业成立的高科技公司。公司继承了七〇九研究所在智能建筑、系统集成、安全防范、信息安全、自动控制等方面的技术、资质和知识产权，承担着七〇九研究所民品产业发展规划、选题、投资和管理职能。\"}],[{\"code\":\"serial\",\"attachInfo\":{\"cessWidth\":\"50\"},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"product\",\"attachInfo\":{},\"name\":\"产品名称\",\"value\":\"Appsay\"},{\"code\":\"finRounds\",\"attachInfo\":{},\"name\":\"当前融资轮次\",\"value\":\"种子轮\"},{\"code\":\"crtTime\",\"attachInfo\":{},\"name\":\"成立日期\",\"value\":\"-\"},{\"code\":\"productLabel\",\"attachInfo\":{},\"name\":\"产品标签\",\"value\":\"企业服务\"},{\"code\":\"affiliation\",\"attachInfo\":{},\"name\":\"所属地\",\"value\":\"-\"},{\"code\":\"introduce\",\"attachInfo\":{\"cessWidth\":\"500\"},\"name\":\"简介\",\"value\":\"Appsay是帮助企业保护用户信息和隐私的可互动平台，为接触银行、学校、非政府组织、医院、保险公司和政府部门等企业提供非入侵式的保密方式。\"}]],\"moduleName\":\"竞品信息\",\"titleInfo\":[{\"code\":\"serial\",\"attachInfo\":{\"cessWidth\":\"50\"},\"name\":\"序号\"},{\"code\":\"product\",\"attachInfo\":null,\"name\":\"产品名称\"},{\"code\":\"finRounds\",\"attachInfo\":null,\"name\":\"当前融资轮次\"},{\"code\":\"crtTime\",\"attachInfo\":null,\"name\":\"成立日期\"},{\"code\":\"productLabel\",\"attachInfo\":null,\"name\":\"产品标签\"},{\"code\":\"affiliation\",\"attachInfo\":null,\"name\":\"所属地\"},{\"code\":\"introduce\",\"attachInfo\":{\"cessWidth\":\"500\"},\"name\":\"简介\"}],\"pageSize\":10,\"pageNum\":1}}";
        SpecialOutputObject specialOutputObject = JSON.parseObject(str, SpecialOutputObject.class);
        return specialOutputObject;
    }
    //@Async
    public ResultData sendEmail(String email){

        if(StringUtils.isNotBlank(email)){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            //发送人
            mailMessage.setFrom(sendPerson);
            //接收人
            mailMessage.setTo(email);
            //邮件主题
            mailMessage.setSubject("博客管理系统验证码");
            //发送内容
            mailMessage.setText("1234");
            mailSender.send(mailMessage);
            return ResultData.success();
        }
        return ResultData.error().message("邮件发送失败!");
    }

    public static void main(String[] args) {
        String str = "{\"returnCode\":\"0\",\"beans\":[],\"resultCode\":\"\",\"returnMessage\":\"success\",\"bean\":{},\"object\":{\"total\":6,\"moduleType\":\"list\",\"dataList\":[[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"河南省源铄互联网产业发展基金(有限合伙)\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"12.698400\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"河南省源铄互联网产业发展基金(有限合伙)\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"12.6984\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"北京山谷创新资产管理有限公司\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"控股股东\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"47.48\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"北京山谷创新资产管理有限公司\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"控股股东\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"47.480000\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"谷晶中\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"3.563500\"}],[{\"code\":\"serial\",\"attachInfo\":{},\"name\":\"序号\",\"value\":\"\"},{\"code\":\"relAname\",\"attachInfo\":{},\"name\":\"关联方名称\",\"value\":\"谷晶中\"},{\"code\":\"relaTypeName\",\"attachInfo\":{},\"name\":\"关联关系\",\"value\":\"实际控制人\"},{\"code\":\"skrto\",\"attachInfo\":{},\"name\":\"占本公司股权比例\",\"value\":\"3.5635\"}]],\"moduleName\":\"参股控股\",\"titleInfo\":[{\"code\":\"serial\",\"attachInfo\":null,\"name\":\"序号\"},{\"code\":\"relAname\",\"attachInfo\":null,\"name\":\"关联方名称\"},{\"code\":\"relaTypeName\",\"attachInfo\":null,\"name\":\"关联关系\"},{\"code\":\"skrto\",\"attachInfo\":null,\"name\":\"占本公司股权比例\"}],\"pageSize\":10,\"pageNum\":1}}";

        System.out.println(str);
    }

    public void test (){

        System.out.println();
    }

}
