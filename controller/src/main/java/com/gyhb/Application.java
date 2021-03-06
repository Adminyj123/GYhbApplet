package com.gyhb;

import com.gyhb.controller.MallProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis 通用maper所在的包
@MapperScan(basePackages = "com.gyhb.mapper")
@ComponentScan(basePackages = {"com.gyhb","org.n3r.idworker"})
@EnableScheduling  //开启定时任务
public class Application {

    final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
