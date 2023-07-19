package com.example;

import java.sql.*;

public class PrepareCompileDemo {
    String name = "john or 1=1";
    String age = "1";

    String sql = "SELECT * FROM user WHERE name = ? AND age = ?";

    public static void main(String[] args) throws SQLException {
        PrepareCompileDemo prepareCompileDemo = new PrepareCompileDemo();
        prepareCompileDemo.play();
    }

    void play() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?" +
                "user=root&password=qq844497663");
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, age);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
        }
    }
    }