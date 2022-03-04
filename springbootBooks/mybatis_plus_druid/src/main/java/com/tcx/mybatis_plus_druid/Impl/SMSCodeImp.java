package com.tcx.mybatis_plus_druid.Impl;

import com.tcx.mybatis_plus_druid.Service.SMSCodeService;
import com.tcx.mybatis_plus_druid.pojo.SMSCode;
import com.tcx.mybatis_plus_druid.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-19:14
 */
@Service
public class SMSCodeImp implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;
    //@Cacheable(value = "smsCode",key = "#tele")
    @CachePut(value = "smsCode",key = "#tele")
    @Override
    public String sendCodeToSMS(String tele) {
        String generator = codeUtils.generator(tele);
        return generator;

    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String code=smsCode.getCode();
        String s = codeUtils.get(smsCode.getTele());
        return s.equals(code);
    }
}
