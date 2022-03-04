package com.tcx.mybatis_plus_druid.Service;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/26-17:06
 */
public interface MsgService {
    String get(String tele);
    Boolean check(String tele,String code);


}
