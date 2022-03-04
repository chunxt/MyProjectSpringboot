package com.example.testconsole.controller;

import com.example.testconsole.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/2-14:39
 */
@RestController
public class Controller1 {
    @RequestMapping(value = "/aaa",method = RequestMethod.POST)
    public void print(@RequestBody User user, HttpServletRequest request){
        System.out.println("当前http的请求方式："+request.getMethod());
        System.out.println(user);
    }
}
