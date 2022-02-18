package com.gyhb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    /*
     *  http://localhost:8089/swagger-ui.html   swagger 原版样式
     *  http://localhost:8089/doc.html          精美版样式
     *
     * */
    //配置swagger2核心配置
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
                   .apiInfo(apiInfo())   //用于定义api文档汇总信息
                   .select().apis(RequestHandlerSelectors
                                    .basePackage("com.gyhb.controller"))  //扫描指定controoler
                   .paths(PathSelectors.any())        //所有controller
                   .build();
    };

     ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("...接口")                   //文档页标题
                .contact(new Contact("某某",
                        "wzdz", //网站的地址
                        "~~的email地址"))       //联系人信息
                .description("专为.....提供的api文档")     //详细信息
                .version("1.0.1")                  //版本号
                .termsOfServiceUrl("https://www.gyhb.com")     //网站的地址
                .build();
    }
}
