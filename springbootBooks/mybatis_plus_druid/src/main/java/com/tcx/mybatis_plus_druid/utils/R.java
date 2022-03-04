package com.tcx.mybatis_plus_druid.utils;

import lombok.Data;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-16:39
 */
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;
    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }
    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
