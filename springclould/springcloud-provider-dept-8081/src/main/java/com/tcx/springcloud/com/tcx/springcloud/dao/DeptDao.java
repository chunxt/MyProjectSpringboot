package com.tcx.springcloud.com.tcx.springcloud.dao;

import com.tcx.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:42
 */
@Mapper
@Repository
//类通过pom导入
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}
