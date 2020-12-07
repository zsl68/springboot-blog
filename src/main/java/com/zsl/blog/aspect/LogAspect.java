package com.zsl.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: 张世林
 * @Date: 2020/12/7 17:39
 * @Description: 日志管理(Aop)
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* com.zsl.blog.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        String url = request.getRequestURL()+"";
        String ip = request.getRemoteAddr();
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,args,methodName);
        logger.info("Request : {}",requestLog);
    }

    @AfterReturning(value = "log()",returning = "result")
    public void AfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private Object args[];
        private String methodName;

        public RequestLog(String url, String ip, Object[] args, String methodName) {
            this.url = url;
            this.ip = ip;
            this.args = args;
            this.methodName = methodName;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", args=" + Arrays.toString(args) +
                    ", methodName='" + methodName + '\'' +
                    '}';
        }
    }
}
