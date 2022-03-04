package com.tcx.mybatis_plus_druid.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcx.mybatis_plus_druid.Service.BookService;
import com.tcx.mybatis_plus_druid.DAO.BookDao;
import com.tcx.mybatis_plus_druid.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-10:46
 */
@Service
public class BookImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    private HashMap<Integer,Book> cache=new HashMap<>();

    /*@Override
    public Book getById(Integer id) {
        Book book = cache.get(id);
        if(book==null){
            Book book1 = bookDao.selectById(id);
            cache.put(id,book1);
            return book1;
        }
        return cache.get(id);
    }*/
    @Override
    @Cacheable(value = "cacheSpace",key="#id")
    public Book getById(Integer id) {

        return bookDao.selectById(id);
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public IPage<Book> getPage(int current, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page=new Page(current,pageSize);
        return bookDao.selectPage(page,lqw);
    }
}
