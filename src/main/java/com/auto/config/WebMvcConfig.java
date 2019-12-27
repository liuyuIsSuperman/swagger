package com.auto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * swagger 过滤网页静态资源
 * @author yusheng
 * @date 2019/10/30 13:43
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resource");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resource/webjars/");
    }
}
