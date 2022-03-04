package com.tcx.mybatis_plus_druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching   //开启缓存功能
public class MybatisPlusDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDruidApplication.class, args);
    }

}
