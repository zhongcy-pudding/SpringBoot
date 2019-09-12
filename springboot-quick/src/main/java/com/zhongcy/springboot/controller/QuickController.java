package com.zhongcy.springboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongcy on 2019/9/11.
 */

@Controller
@ConfigurationProperties(prefix ="person")
public class QuickController {

    private String name;
    private String addr;
    @RequestMapping("/quick")
    @ResponseBody
    public String hello(){
        return "hello springboot h1";
    }

    @RequestMapping("/quick2")
    @ResponseBody
    public String hello2(){
        return "name:"+name+",addr:" +addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
