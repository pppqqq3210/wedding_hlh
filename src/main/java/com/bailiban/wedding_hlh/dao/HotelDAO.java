package com.bailiban.wedding_hlh.dao;

import com.bailiban.wedding_hlh.entity.Hotel;

import java.util.List;

/**
 * 酒店的DAO接口
 */
public interface HotelDAO {

    /**
     * 查询所有酒店
     * @return
     */
    List<Hotel> selectAll();

    /**
     * 查询酒店总数
     * @return
     */
    int selectCount();

    /**
     * 分页查询酒店
     * @param start
     * @param length
     * @return
     */
    List<Hotel> selectLimit(int start,int length);
}
