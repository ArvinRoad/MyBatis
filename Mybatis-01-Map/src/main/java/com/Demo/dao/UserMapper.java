package com.Demo.dao;

import com.Demo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserId(int id);
    //Map02
    User getUserId02(Map<String,Object> map);
    int addUser(User user);
    //万能的Map
    int addUser02(Map<String,Object> map);
    int updateUser(User user);
    int deleteUser(int id);
}
