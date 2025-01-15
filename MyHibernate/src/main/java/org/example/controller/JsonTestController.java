package org.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.TestEntity;
import org.example.entity.MyEntity;
import org.example.entity.SysUser;
import org.example.impl.UserServiceImpl;
import org.example.service.TestService;
import org.example.service.UserService;
import org.example.util.ApplicationContextUtil;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:org.example.controller
 * @Date:2024/1/14
 * @Author:谢锦创
 */
@Controller
@RequestMapping("json")
public class JsonTestController implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private TransactionTest transactionTest;

    @Autowired
    @Qualifier("redisTemplate2")
    private RedisTemplate<String, MyEntity> redisTemplate;

    @Autowired
    private TestService testService;

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

    @Override
//    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(1111);
//        PlatformTransactionManager transactionManager = ApplicationContextUtil.getBean(PlatformTransactionManager.class);
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setName("MyTransaction");
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

//        TransactionStatus status = transactionManager.getTransaction(def);
//        transactionTest.test2();
//        transactionManager.commit(status);
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

    @PostMapping("/testLoadClass")
    @Transactional
    public void testLoadClass() {
//        redisTemplate.opsForValue().set("11","111");
        TestEntity testEntity = new TestEntity("1111");
        System.out.println(testEntity);
    }
    @PostMapping("/testAop")
    @Transactional
    public void testAop() {
        UserService userService = ApplicationContextUtil.getBean(UserService.class);
        SysUser user = userService.getUser("1");
        System.out.println(user);
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

    @PostMapping("/testAsync")
    @ResponseBody
    public String test1() {
        testService.asyncOfThreadLocal();
        JsonTestController bean = ApplicationContextUtil.getBean(JsonTestController.class);
        bean.testMulGet("1");
        return "SUCCESS";
    }

    @PostMapping("/mulTestGet/{id}")
    @ResponseBody
    @Async
//    @Transactional
    public MyEntity testMulGet(@PathVariable("id") String id) {
        String jpql = "from MyEntity";
        Query query = entityManager.createQuery(jpql);
        List<MyEntity> resultList = query.getResultList();
        resultList = resultList.stream().limit(250).collect(Collectors.toList());
//        LocalSessionFactoryBean bean = ApplicationContextUtil.getBean(LocalSessionFactoryBean.class);
//        HibernateUtil.
        SessionFactory sessionFactory = ApplicationContextUtil.getBean(SessionFactory.class);
        Statistics statistics = sessionFactory.getStatistics();
        statistics.setStatisticsEnabled(true); // 开启统计信息
//        statistics.getEntityStatistics("org.example.entity.MyEntity")

// 调用 find 方法
//        statistics.logSummary();
        for (MyEntity myEntity : resultList) {
            entityManager.find(MyEntity.class, myEntity.getId());
        }

        for (MyEntity myEntity : resultList) {
            entityManager.find(MyEntity.class, myEntity.getId());
        }



//        for (MyEntity myEntity: resultList) {
//            processReturn(myEntity);
//            entityManager.find(MyEntity.class, "1");
//        }

//        MyEntity myEntity = entityManager.find(MyEntity.class, id);
//        myEntity.setDyEnum("\\");
//        System.out.println(myEntity);
        System.out.println("refresh to the end");
        return resultList.get(0);
    }

    private void processReturn(MyEntity myEntity) {
        Field mulReference = ReflectionUtils.findField(MyEntity.class, "id");
//        ReflectionUtils.makeAccessible(mulReference);
        try {
            System.out.println(mulReference.get(myEntity));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
