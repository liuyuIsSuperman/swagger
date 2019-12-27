package com.auto.controller;

import com.auto.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yusheng
 * @date 2019/10/30 10:14
 */
@RestController("/helloSwagger")
public class helloSwagger {

    @GetMapping("/swagger")
    public String demo(){
        return "HELLO SWAGGER!";
    }

    @ApiOperation("user控制类")
    @GetMapping("/user")
    public User user(){
        return new User();
    }
}
