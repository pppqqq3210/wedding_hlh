package com.bailiban.wedding_hlh.controller;

import com.bailiban.wedding_hlh.entity.User;
import com.bailiban.wedding_hlh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("user")
public class UserController {

    //注入service对象
    @Autowired
    private UserService userService;

    //登录操作 http://localhost:8080/user/login
    //GET会将密码显示出来，POST是后台提交不显示密码更安全
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Model model,String username, String password){
        //实现验证
        User user = userService.login(username,password);
        if(user != null){
            //验证成功，跳转到返回主界面的方法 redirect是重定向到另一个方法，刷新浏览器，清空数据
            return "redirect:/index.html";
        }
        //绑定错误提示信息
        model.addAttribute("msg","账号或密码错误");
        //登录不成功，跳转登录页面 forward是请求分发，不会刷新浏览器，保留数据
        return "forward:/login.html";
    }
}
