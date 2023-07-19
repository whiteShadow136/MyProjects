package com.example;

import com.example.User;
import com.example.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisDemo {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

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
                User retrievedUser = userMapper.getUserById("User", 1);
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
                sqlSession.rollback();
                e.printStackTrace();
            } finally {
                // 关闭SqlSession
                sqlSession.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
