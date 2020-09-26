package com.yuanzh.dao;

import com.yuanzh.Entity.User;
import com.yuanzh.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao  {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginUser) {
        /* 没有找到行
        [http-nio-8080-exec-7] com.alibaba.druid.pool.DruidDataSource.info {dataSource-1} inited
org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
	at org.springframework.dao.support.DataAccessUtils.requiredSingleResult(DataAccessUtils.java:74)
	at org.springframework.jdbc.core.JdbcTemplate.queryForObject(JdbcTemplate.java:777)
	at com.yuanzh.dao.UserDao.login(UserDao.java:19)

         */
        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int register(User regisUser) {
        try {
            String sql = "insert into user (`username`,`password`) values (?,?);";
            template.update(sql,regisUser.getUsername(),regisUser.getPassword());
            return 0;
        }catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
