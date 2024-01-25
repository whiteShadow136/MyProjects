package org.example;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Users;

/**
 * @Description:org.example
 * @Date:${DATE}
 * @Author:谢锦创
 */
public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        JSONArray jsonValues = new JSONArray();
        jsonValues.add(new Users(1L, "xie", "qq"));
//        PersistObject persistObject = new PersistObject(1, jsonValues, new Student(1, "谢锦创"));


//        String s1 = JSON.toJSONString(persistObject);
//        System.out.println(s1);

        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(persistObject);
//        System.out.println(s);

        System.out.println("Hello world!");
    }

    void test() {

    }
}