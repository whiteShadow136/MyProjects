package com.example.controller;

import com.example.User;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Component
public class MyBatisDemo {

    public MyBatisDemo() {
        System.out.println(1111);
    }

    @Autowired
//    @Qualifier(value = "getSqlSession")
    private SqlSession sqlSession;
    public static void main(String[] args) {
        String resource = "/mybatis-config";
        InputStream inputStream;
        MyBatisDemo myBatisDemo = new MyBatisDemo();
//        sqlSession = myBatisDemo.getSqlSession(resource);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<?> submit = executorService.submit(() -> myBatisDemo.userExecute());
//        Future<?> submit1 = executorService.submit(() -> myBatisDemo.userExecute());
//        Future<?> submit2 = executorService.submit(() -> myBatisDemo.userExecute());
//        myBatisDemo.userExecute("user", 1);
//        myBatisDemo.userExecute("user", 2);
//        myBatisDemo.userExecute("user", 3);
//        myBatisDemo.userExecute("user", 4);
//        myBatisDemo.userExecute("user", 5);
//        myBatisDemo.userExecute("user", 6);
    }

    @Transactional
    public void userExecute(String table, int userId) {
        try {
            // 获取UserMapper接口的实例
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 插入用户
//                User user = new User();
//                user.setId(1);
//                user.setName("John");
//                user.setAge(25);
//                userMapper.insertUser(user);
//                System.out.println("插入用户成功");

            // 根据id查询用户
            User retrievedUser = userMapper.getUserById(table, userId);
//            new ObjectInputStream()
            System.out.println("查询用户：" + retrievedUser);

//                // 更新用户
//                retrievedUser.setAge(30);
//                userMapper.updateUser(retrievedUser);
//                System.out.println("更新用户成功");
//
//                // 再次查询用户
//                retrievedUser = userMapper.getUserById(1);
//                System.out.println("查询用户：" + retrievedUser);
//
//                // 删除用户
//                userMapper.deleteUserById(1);
//                System.out.println("删除用户成功");
//
//                // 提交事务
//                sqlSession.commit();
        } catch (Exception e) {
            // 发生异常时回滚事务
//            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            // 关闭SqlSession
//            sqlSession.close();
        }
    }



    SqlSession getSqlSession(String fileName) {
        URL resource = this.getClass().getResource(fileName);
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource.openStream());
            sqlSession = sqlSessionFactory.openSession();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
