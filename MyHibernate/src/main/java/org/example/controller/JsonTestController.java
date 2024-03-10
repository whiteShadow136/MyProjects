package org.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mysql.cj.xdevapi.JsonArray;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.commons.lang3.time.DateUtils;
import org.example.entity.MyEntity;
import org.example.enums.Result;
import org.example.event.PostStoreEvent;
import org.example.listener.PostStoreListener;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

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

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public JsonTestController() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/jsonTest")
    @Transactional
    @ResponseBody
    public MyEntity jsonTest(@RequestBody  MyEntity myEntity1) {
        MyEntity myEntity = new MyEntity();
        myEntity.setId(UUID.randomUUID().toString());
        myEntity.setDyEnum("A");
        myEntity.setRdmExtensionType("DyEnumExt");
        myEntity.setNameEn("DyEnum");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("clazz", MyEntity.class);
        jsonArray.add(jsonObject);
        myEntity.setMulReference(jsonArray);
        JSONArray jsonArrayTest = new JSONArray();
        JSONObject jsonObjectTest = new JSONObject();
        jsonObjectTest.put("id", 1);
        jsonObjectTest.put("name", 2);
        jsonArrayTest.add(jsonObjectTest);
        myEntity.setJsonArrayTest(jsonArrayTest);
        myEntity.setCreateTime(LocalDateTime.now());
        myEntity.setLastUpdateTime(LocalDateTime.now());
        entityManager.merge(myEntity);
        entityManager.flush();
//        applicationEventPublisher.publishEvent(new PostStoreEvent(myEntity));
        return myEntity;
    }

    @PostMapping("/mulTest")
    @Transactional
    public void testMul() {
        MyEntity myEntity = new MyEntity();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("123");
        jsonArray.add("456");
        myEntity.setMulReference(jsonArray);
        myEntity.setId("1");
        entityManager.merge(myEntity);
    }

    @PostMapping("/mulTestGet/{id}")
    public void testMulGet(@Param("id") String id) {
        MyEntity myEntity = entityManager.find(MyEntity.class, id);
        System.out.println(myEntity);
    }
}
