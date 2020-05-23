package com.bailiban.wedding_hlh.dao;

import com.bailiban.wedding_hlh.entity.User;

/**
 * 用户DAO接口
 */
public interface UserDAO {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
