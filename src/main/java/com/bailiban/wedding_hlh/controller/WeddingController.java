package com.bailiban.wedding_hlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制器
 */
@Controller
public class WeddingController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    //@ResponseBody的作用时将数据直接返回到浏览器
    public String hello(){
        return "Hello ，我启动了SpringBoot项目";
    }

    //访问wedding.html文件的方法
    @RequestMapping("index")
    //没有@ResponseBody，springboot通过返回值去搜索html文件，返回给浏览器
    public String index(){
        //返回页面的文件名，不加后缀
        return "wedding";
    }
}
