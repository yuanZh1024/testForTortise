package com.yuanzh.dao;

import com.yuanzh.domain.User;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     */
    List<User>  findAll();

}
