package com.bailiban.wedding_hlh.service;

import com.bailiban.wedding_hlh.entity.User;

/**
 * 用户业务逻辑接口
 */
public interface UserService {

    User login(String username, String password);

    void register(String username,String password);

    User selectUserByTel(String username);
}
