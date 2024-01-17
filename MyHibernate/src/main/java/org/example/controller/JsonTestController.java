package org.example.controller;

import org.example.entity.PersistObject;
import org.example.entity.enums.Result;
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
        PersistObject persistObject = new PersistObject();
        persistObject.setId(1);
        persistObject.setResult(Result.FAIL);
        persistObject.setName("A");
        entityManager.merge(persistObject);
        System.out.println(11111);
    }
}
