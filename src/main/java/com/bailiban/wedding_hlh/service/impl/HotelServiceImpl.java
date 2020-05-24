package com.bailiban.wedding_hlh.service.impl;

import com.bailiban.wedding_hlh.dao.HotelDAO;
import com.bailiban.wedding_hlh.entity.Hotel;
import com.bailiban.wedding_hlh.entity.Page;
import com.bailiban.wedding_hlh.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * HotelDAO的实现
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public List<Hotel> selectAll() {
        return hotelDAO.selectAll();
    }

    @Override
    public Page<Hotel> selectPage(int currentPage) {
        //获得页面总数
        int total = hotelDAO.selectCount();
        //确定每一页行数，计算出分页数量
        int pageSize = 3;
        int pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        //实现分页查询 currentPage从1开始，要减一
        List<Hotel> hotels = hotelDAO.selectLimit(pageSize * (currentPage - 1), pageSize);
        //返回分页对象
        Page<Hotel> page = new Page<Hotel>();
        page.setCurrentPage(currentPage);
        page.setData(hotels);
        page.setPageCount(pageCount);
        return page;
    }
}
