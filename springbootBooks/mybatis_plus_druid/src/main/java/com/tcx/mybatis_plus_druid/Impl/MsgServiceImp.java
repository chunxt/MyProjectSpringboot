package com.tcx.mybatis_plus_druid.Impl;

import com.tcx.mybatis_plus_druid.Service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-17:09
 */
@Service
public class MsgServiceImp implements MsgService {
    private HashMap<String,String> cache=new HashMap<>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele,code);
        return code;
    }

    @Override
    public Boolean check(String tele, String code) {
        String querryCode = cache.get(tele);
        return code.equals(querryCode);
    }
}
