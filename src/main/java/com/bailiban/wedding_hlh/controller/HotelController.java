package com.bailiban.wedding_hlh.controller;

import com.bailiban.wedding_hlh.entity.Hotel;
import com.bailiban.wedding_hlh.entity.Page;
import com.bailiban.wedding_hlh.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 酒店控制器
 */
@Controller
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping("list")
    public String listHotels(Model model){
        List<Hotel> hotels = hotelService.selectAll();
        //把数据存入到模型中
        model.addAttribute("hotels",hotels);
        //返回视图文件名
        return "field";
    }

    /**
     * 分页查询
     * @param model
     * @param currentPage
     * @return
     */
    @RequestMapping("page")
    public String pageHotels(Model model,Integer currentPage){
        //页数默认从1开始
        if(currentPage == null){
            currentPage = 1;
        }
        Page<Hotel> hotelPage = hotelService.selectPage(currentPage);
        model.addAttribute("page",hotelPage);
        return "field";
    }
}
