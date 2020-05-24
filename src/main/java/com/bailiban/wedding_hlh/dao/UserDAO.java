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

    /**
     * 用户注册
     * @param username
     * @param password
     */
    void register(String username,String password);

    /**
     * 通过手机号查询用户
     * @param username
     * @return
     */
    User selectUserByTel(String username);
}
