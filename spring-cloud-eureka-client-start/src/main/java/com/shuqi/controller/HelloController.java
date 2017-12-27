package com.shuqi.controller;

import com.shuqi.entity.GatewayReq;
import com.shuqi.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        log.info("hello world");
        return "hello world";
    }

    @RequestMapping(value = "parse",method = RequestMethod.POST)
    public String parse(@RequestBody GatewayReq gatewayReq){
        log.info("gatewayReq:{}",gatewayReq);
        return "接收成功";
    }

    @RequestMapping(value = "parse2",method = RequestMethod.POST)
    public String parse2(@RequestBody User user){
        log.info("user:{}",user);
        return "接收成功";
    }
}
