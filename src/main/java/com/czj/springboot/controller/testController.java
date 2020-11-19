package com.czj.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试接口")
@RestController
@RequestMapping("/test")
public class testController {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String test(){
        return "hello world";
    }
}
