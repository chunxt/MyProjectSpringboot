package com.tcx.mybatis_plus_druid.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcx.mybatis_plus_druid.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/16-11:44
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
