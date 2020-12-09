package com.zsl.blog.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
//统一返回结果的类
public class ResultData {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    //然后把构造方法私有 只能使用规定好的返回结果
    private ResultData() {}

    //链式编程
    //R.success.data.message

    //静态成功方法
    public static ResultData success(){
        ResultData r = new ResultData();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage("成功");
        return r;
    }

    //静态失败方法
    public static ResultData error(){
        ResultData r = new ResultData();
        r.setCode(500);
        r.setSuccess(false);
        r.setMessage("失败");
        return r;
    }

    public ResultData success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultData message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultData code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultData data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultData data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
