package com.auto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * @author yusheng
 * @date 2019/10/30 10:13
 */
@Configuration
@EnableSwagger2//开启swagger2
public class swaggerConfig {

    @Bean
    public Docket docket1(){
         return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    } @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }




    //配置swagger bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //environment.acceptsProfiles判断是否在自己设定的环境中
        boolean flag= environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("刘宇")
                .select()
                /**
                 * any():扫描全部
                 * none():都不扫描
                 */
                .apis(RequestHandlerSelectors.basePackage("com.auto.controller"))
                /**
                 * paths();过滤路径
                 */
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("测试api文档")
                .description("测试api文档")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();

    }

}
