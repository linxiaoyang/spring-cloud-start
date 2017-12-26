package com.shuqi.controller;

import com.shuqi.entity.GatewayReq;
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
        return "hello world";
    }

    @RequestMapping(value = "parse",method = RequestMethod.POST)
    public String parse(@RequestBody GatewayReq gatewayReq){
        log.info("gatewayReq:{}",gatewayReq);
        return "接收成功";
    }
}