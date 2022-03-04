package com.tcx.mybatis_plus_druid.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/18-11:18
 */
//做springMVC的异常处理器
@RestControllerAdvice
public class projectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler  //处理异常的方法
    public R doException(Exception ex){
        //记录日志，通知运维，通知开发
        ex.printStackTrace();  //在控制台打印异常信息
        // return的东西到前端，将异常信息统一格式
        return new R("服务器故障，请稍后再试！");
    }
}
