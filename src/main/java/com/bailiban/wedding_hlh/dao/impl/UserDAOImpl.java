package com.bailiban.wedding_hlh.dao.impl;

import com.bailiban.wedding_hlh.dao.UserDAO;
import com.bailiban.wedding_hlh.entity.User;
import com.bailiban.wedding_hlh.util.MockData;
import org.springframework.stereotype.Repository;

/**
 * 用户DAO的实现
 * Repository被spring扫描，并创建对象
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public User login(String username, String password) {
        for (User user : MockData.users){
            //模拟数据库账号密码验证
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
