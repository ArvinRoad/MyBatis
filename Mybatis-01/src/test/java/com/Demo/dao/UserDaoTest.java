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

        //手动关闭(确保所有数据库资源都能被正常的关闭)
        try {
            //方式一：getMapper 执行SQL
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            //方式二：了解就可以（已经过时了）
            //List<User> UserList02 = sqlSession.selectList("com.Demo.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

            //for (User user : UserList02) {
            //System.out.println(user);
           // }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

}
