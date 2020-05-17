package com.bailiban.wedding_hlh.service.impl;

import com.bailiban.wedding_hlh.dao.UserDAO;
import com.bailiban.wedding_hlh.dao.impl.UserDAOImpl;
import com.bailiban.wedding_hlh.entity.User;
import com.bailiban.wedding_hlh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑的实现
 */
@Service
public class UserServiceImpl implements UserService {

//    private UserDAO userDAO = new UserDAOImpl();

    //Autowired实现对象的注入
    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        //调用dao层的对象
        return userDAO.login(username,password);
    }
}
