package com.tcx.mybatis_plus_druid.controller;

import com.tcx.mybatis_plus_druid.Service.SMSCodeService;
import com.tcx.mybatis_plus_druid.pojo.SMSCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-19:15
 */
@RestController
@RequestMapping("/sms")
public class SMSController {
    @Autowired
    private SMSCodeService smsCodeService;
    @GetMapping()
    public String getCode(String tele){
        String s = smsCodeService.sendCodeToSMS(tele);
        return s;
    }
    @PostMapping
    public Boolean checkCode(SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }
}
