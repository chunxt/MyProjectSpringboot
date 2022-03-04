package com.tcx.mybatis_plus_druid.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-19:20
 */
@Component
public class CodeUtils {
    //计算六位验证码
    public String generator(String tele){
        int hash=tele.hashCode();
        int encryption=20206666;
        long result = hash ^ encryption;
        long nowTime=System.currentTimeMillis();
        result=result^nowTime;
        long code=result%1000000;
        code=code<0?-code:code;
        String codeStr=code+"";
        int len=codeStr.length();
        String[] zeros={"00000","0000","000","00","0",""};
        String newCode=zeros[len-1]+codeStr;
        return newCode;
    }
    @Cacheable(value = "smsCode",key="#tele")
    public String get(String tele){
        return null;
    }
}
