package com.tcx.mybatis_plus_druid.controller;

import com.tcx.mybatis_plus_druid.Service.BookService;
import com.tcx.mybatis_plus_druid.Service.MsgService;
import com.tcx.mybatis_plus_druid.pojo.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-16:07
 */
@Slf4j
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    MsgService msgService;
    @GetMapping("{tele}")
    public String send(@PathVariable String tele){
        return msgService.get(tele);
    }
    @PostMapping
    public Boolean check(String tele,String code){
        return msgService.check(tele,code);
    }
    @Autowired
    BookService bookService;
    @GetMapping("{id}")
    public Book getById(int id){
        return bookService.getById(id);
    }


}
