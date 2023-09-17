package com.example.mapper;

import com.example.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserById(@Param("tableName") String tableName, @Param("id") int id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);
}
