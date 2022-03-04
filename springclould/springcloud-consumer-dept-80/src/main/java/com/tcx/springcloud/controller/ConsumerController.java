package com.tcx.springcloud.controller;

import com.tcx.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Cxt
 * @Date 2022-03-2022/3/1-20:56
 */
@RestController
public class ConsumerController {
    //消费者，不应该有service层
    //RestTemplate,有很多方法，可以调用，由于它没有bean，所以要手动的注册进去
    //(URL，实体：Map，Class<T> respondeType)
    private static final String REST_URL_PREFIX="http://localhost:8081";
    @Autowired
    private RestTemplate restTemplate;   //提供多种便捷访问远程http服务的方法，简单的Restful服务模板
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/list",List.class);
    }
}
