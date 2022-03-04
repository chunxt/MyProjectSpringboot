package com.tcx.mybatis_plus_druid.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tcx.mybatis_plus_druid.pojo.Book;

import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-10:44
 */
public interface BookService {
    Boolean save(Book book);
    Boolean deleteById(Integer id);
    List<Book> getAll();
    Book getById(Integer id);
    Boolean update(Book book);
    IPage<Book> getPage(int current, int pageSize, Book book);
}
