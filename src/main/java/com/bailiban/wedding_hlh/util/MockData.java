package com.bailiban.wedding_hlh.util;

import com.bailiban.wedding_hlh.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据
 */
public class MockData {

    /**
     * 模拟用户数据库
     */
    public static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("15667778888","123456"));
        users.add(new User("15667779999","123456"));
        users.add(new User("15667776666","123456"));
    }
}
