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
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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

    ThreadLocal<HashMap<String, String>> enumThreadLocal = new ThreadLocal<>();

    public JsonTestController() {
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void main(String[] args) {
        JsonTestController jsonTestController = new JsonTestController();
        jsonTestController.test();
    }

    public void test() {
        TestReflect myEntity = new TestReflect("11111");
        try {
            Field bean = myEntity.getClass().getDeclaredField("bean");
//            testName.set(myEntity, "1111");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class TestReflect{
        private final Object bean;

        public TestReflect(Object bean) {
            this.bean = bean;
        }
    }


    @PostMapping("/jsonTest")
    @Transactional
    @ResponseBody
    public MyEntity jsonTest(@RequestBody  MyEntity myEntity1) {
        for (int i = 0; i < 8000; i++) {
            MyEntity myEntity = new MyEntity();
            myEntity.setId(UUID.randomUUID().toString());
            myEntity.setDyEnum("A");
            myEntity.setRdmExtensionType("DyEnumExt");
            myEntity.setNameEn("\\");
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
            entityManager.persist(myEntity);
        }
            entityManager.flush();
//        applicationEventPublisher.publishEvent(new PostStoreEvent(myEntity));
        return myEntity1;
    }

    @PostMapping("/mulTest")
    @Transactional
    public void testMul() {
        MyEntity myEntity = new MyEntity();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("123");
        jsonArray.add("456");
        myEntity.setMulReference(jsonArray);
        myEntity.setId("1000");
        entityManager.merge(myEntity);
    }

    @PostMapping("/mulTestGet/{id}")
    @ResponseBody
    public MyEntity testMulGet(@PathVariable("id") String id) {
        String jpql = "from MyEntity";
        Query query = entityManager.createQuery(jpql);
        List<MyEntity> resultList = query.getResultList();
        Field mulReference = ReflectionUtils.findField(MyEntity.class, "id");
//        mulReference.setAccessible(true);
        ReflectionUtils.makeAccessible(mulReference);
        for (MyEntity myEntity: resultList) {
            try {
                System.out.println(mulReference.get(myEntity));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
//            entityManager.find(MyEntity.class, "1");
        }

//        MyEntity myEntity = entityManager.find(MyEntity.class, id);
//        myEntity.setDyEnum("\\");
//        System.out.println(myEntity);
        return resultList.get(0);
    }
}
