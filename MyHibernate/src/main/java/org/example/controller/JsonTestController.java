package org.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import io.lettuce.core.dynamic.annotation.Param;
import org.example.entity.MyEntity;
import org.example.enums.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:org.example.controller
 * @Date:2024/1/14
 * @Author:谢锦创
 */
@Controller
@RequestMapping("json")
public class JsonTestController {

    @Autowired
    EntityManager entityManager;


    @PostMapping("/jsonTest")
    @Transactional
    public void jsonTest() {
        // 生成一个jsonObject字符串
        HashMap<Integer, String> cache = new HashMap<>();
        cache.put(1, "1");
        cache.put(2, "1");
        cache.put(3, "1");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        MyEntity myEntity = new MyEntity();
        myEntity.setId("1");
        myEntity.setResult(Result.FAIL);
        myEntity.setDyEnum("A");
        entityManager.merge(myEntity);
        System.out.println(11111);
    }

    @PostMapping("/mulTest")
    @Transactional
    public void testMul() {
        MyEntity myEntity = new MyEntity();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("123");
        jsonArray.add("456");
        myEntity.setMulReference(jsonArray);
        myEntity.setName("mul");
        myEntity.setResult(Result.SUCCESS);
        myEntity.setId("1");
        entityManager.merge(myEntity);
    }

    @PostMapping("/mulTestGet/{id}")
    public void testMulGet(@Param("id") String id) {
        MyEntity myEntity = entityManager.find(MyEntity.class, id);
        System.out.println(myEntity);
    }
}
