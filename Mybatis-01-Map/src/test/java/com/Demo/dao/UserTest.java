package com.Demo.dao;

import com.Demo.pojo.User;
import com.Demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userId = mapper.getUserId(1);
        System.out.println(userId);
        sqlSession.close();
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int addUser = mapper.addUser(new User(5, "MyLise", "7788995566"));
        if (addUser>0){
            System.out.println("addUser执行成功，用户已添加");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser02Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //创建Map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid",5);
        map.put("username","TiMLie");
        map.put("password","999888777");

        int addUser02 = mapper.addUser02(map);
        if (addUser02>0){
            System.out.println("addUser02执行成功，用户已通过Map创建");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = mapper.updateUser(new User(1, "Arvin", "123456789"));
        if (updateUser>0){
            System.out.println("updateUser执行成功，用户已修改");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(5);
        if (deleteUser>0){
            System.out.println("deleteUser执行成功，用户已删除");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
