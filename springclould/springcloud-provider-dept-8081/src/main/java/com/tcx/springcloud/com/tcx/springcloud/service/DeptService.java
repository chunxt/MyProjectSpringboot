package com.tcx.springcloud.com.tcx.springcloud.service;

import com.tcx.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:42
 */
public interface DeptService {
    boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}