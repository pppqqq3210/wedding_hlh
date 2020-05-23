package com.bailiban.wedding_hlh.controller;

import com.bailiban.wedding_hlh.entity.User;
import com.bailiban.wedding_hlh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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
    public String login(Model model,HttpSession session,
                        String username, String password,String code){
        //实现验证码的判断
        //从session中取验证码
        String rightCode = (String) session.getAttribute("code");
        if(rightCode == null || code == null || !rightCode.equals(code)){
            model.addAttribute("msg","验证码错误");
            return "forward:/login.html";
        }
        //实现验证
        User user = userService.login(username, password);
        if(user != null){
            //验证成功，跳转到返回主界面的方法 redirect是重定向到另一个方法，刷新浏览器，清空数据
            return "redirect:/index.html";
        }
        //绑定错误提示信息
        model.addAttribute("msg","账号或密码错误");
        //登录不成功，跳转登录页面 forward是请求分发，不会刷新浏览器，保留数据
        return "forward:/login.html";
    }

    /**
     * 生成验证码
     * @param session    保存验证码
     * @param response   发送验证码给浏览器
     */
    @RequestMapping("code")
    public void createCode(HttpSession session, HttpServletResponse response) throws IOException {
        Random random = new Random();
        //定义图片的宽和高
        int width = 80;
        int height = 35;
        //定义字体大小
        int fontSize = 20;
        //创建缓冲图片（保存到内存）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        //获得图片的绘图对象 awt
        Graphics g = image.getGraphics();
        //设置背景颜色 awt
        g.setColor(Color.GRAY);
        //填充矩形背景颜色
        g.fillRect(0,0,width,height);
        //设置字体
        g.setFont(new Font("宋体",Font.PLAIN,fontSize));
        //定义保存字母和数字的字符串
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        //定义颜色的数组
        Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,
                Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};
        //连接4个字母或数字
        StringBuilder stringBuilder = new StringBuilder();
        //随机生成4个字母或数字
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(random.nextInt(str.length()));
            //随机取验证，将文字绘制到图片上
            g.setColor(colors[random.nextInt(colors.length)]);
            //绘制文字，参数1 文字 参数2 横坐标 参数3 纵坐标
            g.drawString(String.valueOf(ch), fontSize * i + 5,fontSize + 5);
            //绘制随机的线条
            g.setColor(colors[random.nextInt(colors.length)]);
            g.drawLine(random.nextInt(width),random.nextInt(height),
                    random.nextInt(width),random.nextInt(height));
            //StringBuilder在进行频繁字符串处理时不会创建新字符串，效率高
            stringBuilder.append(ch);
        }
        System.out.println("验证码：" + stringBuilder.toString());
        //把验证码保存到Session中，Session将当前用户的信息保存起来，在用户访问的各个程序（页面、控制器等）中使用
        session.setAttribute("code",stringBuilder.toString());
        //设置响应头，让浏览器不缓存图片
        response.addHeader("Cache-Control","no-cache");
        //将验证码通过流发送给浏览器 ImageIO发送图片的工具类 参数1 图片 参数2 格式 参数3 输出流
        ImageIO.write(image,"PNG",response.getOutputStream());
    }
}
