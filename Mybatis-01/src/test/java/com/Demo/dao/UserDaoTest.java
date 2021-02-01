package com.Demo.dao;

import com.Demo.pojo.User;
import com.Demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

//测试类
public class UserDaoTest {
    @Test
    public void test(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper 执行SQL
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

}
