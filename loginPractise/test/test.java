package com.yuanzh.test;

import com.yuanzh.Entity.User;
import com.yuanzh.dao.UserDao;


public class test {
    public void TestLogin()
    {
        User user = new User;
        user.setUsername("san");
        user.setPassword("23");
        UserDao userdao = new UserDao();
        userdao.login(user);

        System.out.println(user);
    }
}
