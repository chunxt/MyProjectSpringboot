package com.tcx.mybatis_plus_druid.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tcx.mybatis_plus_druid.Service.BookService;
import com.tcx.mybatis_plus_druid.pojo.Book;
import com.tcx.mybatis_plus_druid.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-16:07
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping()
    public R getAll(){
        return new R(true,bookService.getAll());
    }
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        Boolean flag = bookService.save(book);
        //if(book.getName().equals("123")) throw new IOException();
        //return new R(bookService.save(book));
        System.out.println(book);
        return new R(flag,flag?"添加成功^~^":"添加失败-_-!");
    }
    @PutMapping
    public R update(@RequestBody Book book){
        Boolean flag=bookService.update(book);
        return new R(flag,flag?"更新成功^~^":"更新失败-_-!");
        //return new R(bookService.update(book));
    }
    @DeleteMapping("/del/{id}")
    public R delete(@PathVariable int id){
        Boolean flag=bookService.deleteById(id);
        return new R(flag,flag?"删除成功^~^":"删除失败-_-!");
        //return new R(bookService.deleteById(id));
    }
    @GetMapping("/get/{id}")
    public R getById(@PathVariable int id){
        return new R(true,bookService.getById(id));
    }
    @GetMapping("{current}/{pageSize}")
    public R getPage(@PathVariable int current,@PathVariable int pageSize,Book book){
        //如果分页数大于总的页数，领当前页为最大页码数
        IPage<Book> page = bookService.getPage(current, pageSize,book);
        if(current>page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }

}
