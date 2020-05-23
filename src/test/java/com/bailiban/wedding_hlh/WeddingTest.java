package com.bailiban.wedding_hlh;


import com.bailiban.wedding_hlh.dao.UserDAO;
import com.bailiban.wedding_hlh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试类
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WeddingTest {


    @Autowired
    private UserDAO userDAO;

    @Test
    public void testLogin(){
        User user = userDAO.login("13260621887", "123456");
        System.out.println(user);
    }
}
