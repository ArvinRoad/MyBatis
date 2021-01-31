package com.Demo.dao;

import com.Demo.pojo.User;
import java.util.List;

//实体类接口
public interface UserDao {
    List<User> getUserList();
}
