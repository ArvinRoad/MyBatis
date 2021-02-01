package com.Demo.dao;

import com.Demo.pojo.User;

import java.util.List;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);
}
