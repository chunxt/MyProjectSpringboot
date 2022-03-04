package com.tcx.springcloud.com.tcx.springcloud.controller;

import com.tcx.springcloud.com.tcx.springcloud.service.DeptService;
import com.tcx.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:50
 */
//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping( "/dept/get/{id}")
    public Dept selectById(@PathVariable long id){
        return deptService.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> selectAll(){
        return deptService.queryAll();
    }

}
