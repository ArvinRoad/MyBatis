### MyBatis参考文档

MyBatis核心配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--父工程配置文件-->
    <groupId>org.example</groupId>
    <artifactId>Mybatis-Study</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!--导入依赖-->
    <dependencies>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>

</project>
```

MyBatis核心配置文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--MyBatis核心配置文件-->
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;"/>
                <property name="username" value="root"/>
                <property name="password" value="1917723401Syc"/>
            </dataSource>
        </environment>
    </environments>


</configuration>
```

MyBatis项目Mapper.xml文件配置注册

报错码： org.apache.ibatis.binding.BindingException: Type interface com.Demo.dao.UserDao is not known to the MapperRegistry.
```xml
<!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
    <mappers>
        <mapper resource="com/Demo/dao/UserMapper.xml"/>
    </mappers>
```
MyBatis项目资源导入出错配置文件

报错码：java.lang.ExceptionInInitializerError[The error may exist in com/Demo/dao/UserMapper.xml]
```xml
    <!--在build中配置resources，来防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

MyBatis官方建议SQL资源正常手动关闭
```java
public class UserDaoTest {
    @Test
    public void test(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //手动关闭(确保所有数据库资源都能被正常的关闭)
        try {
            //getMapper 执行SQL
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){ 
            //抛出异常（这个异常是不会成功捕获的，只是官方建议这样写）
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
```

db.properties配置文件[SQL配置文件]
```properties
driver = com.mysql.jdbc.Driver
url = jdbc:mysql://localhost:3306/mybatis?useSSL=false&;useUnicode=true&;characterEncoding=UTF-8
username = root
password = 1917723401Syc
```