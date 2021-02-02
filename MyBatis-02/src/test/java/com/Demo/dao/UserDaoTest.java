package com.Demo.dao;

import com.Demo.pojo.User;
import com.Demo.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserList(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int addUser = mapper.addUser(new User(5, "LiMoi", "7744588664"));
        sqlSession.commit();
        if (addUser>0){
            System.out.println("addUser执行成功，用户已添加");
        }
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = mapper.updateUser(new User(1, "Arvin", "1917723401"));
        sqlSession.commit();
        if (updateUser>0){
            System.out.println("updateUser执行成功，用户已修改");
        }
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(5);
        sqlSession.commit();
        if (deleteUser>0){
            System.out.println("deleteUer执行成功，用户已删除");
        }
        sqlSession.close();
    }
}
