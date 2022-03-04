package com.tcx.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:30
 */
//所有的实体类必须实现序列化，否则传输会出现错误
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {
    private Long deptno;  //主键
    private String deptname;
    //这个数据存在哪个数据库的字段，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String deptname) {
        this.deptname = deptname;
    }
}

