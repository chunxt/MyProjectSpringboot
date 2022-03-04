package com.tcx.mybatis_plus_druid.Service;

import com.tcx.mybatis_plus_druid.pojo.SMSCode;
import org.springframework.stereotype.Service;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-19:12
 */
//@Service
public interface SMSCodeService {
    String sendCodeToSMS(String tele);
    Boolean checkCode(SMSCode smsCode);
}
