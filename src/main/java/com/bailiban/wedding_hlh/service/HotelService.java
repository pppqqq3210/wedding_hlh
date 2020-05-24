package com.bailiban.wedding_hlh.service;

import com.bailiban.wedding_hlh.entity.Hotel;
import com.bailiban.wedding_hlh.entity.Page;

import java.util.List;

/**
 * 酒店业务逻辑接口
 */
public interface HotelService {

    List<Hotel> selectAll();

    /**
     * 分页查询
     * @param currentPage 当前页数 从1开始
     * @return 分页对象
     */
    Page<Hotel> selectPage(int currentPage);
}
