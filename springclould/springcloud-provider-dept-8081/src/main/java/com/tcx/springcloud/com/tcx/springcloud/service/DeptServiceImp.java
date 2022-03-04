package com.tcx.springcloud.com.tcx.springcloud.service;

import com.tcx.springcloud.com.tcx.springcloud.dao.DeptDao;
import com.tcx.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:43
 */
@Service
public class DeptServiceImp implements DeptService{
    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}