package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.example.config.ThreadPoolConfig;
import org.example.entity.*;
import org.example.impl.UserServiceImpl;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("MyThreadPoolExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    // 获取用户信息
    @GetMapping("/{id}")
    @ResponseBody
    @Transactional
    public SysUser getUser(@PathVariable String id) throws ExecutionException, InterruptedException {
//        SysUser user = userService.getUser(id);
//        System.out.println(1111);
//        userService.asyncMethodA();
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    userService.asyncMethodA();
                    return null;
                },
                threadPoolTaskExecutor);
//        Object o = objectCompletableFuture.get();
        userService.asyncMethodB();
//        Optional<Users> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        List list = new ArrayList<String>();
        list.add("id:1,type:String");
        list.add("id:2,type:Integer");
//        1. 使用字符串拼接
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//            if (i < list.size() - 1) {
//                sb.append(";");
//            }
//        }
//        Arrays.stream(values).findFirst()


//        2. 使用stream流，但是好像有点慢
//        String result = list.stream().map(s -> "\"" + s + "\"").collect(Collectors.joining(";"));
//        result = "[" + result + "]";
        JSON.toJSONString(list);
        return new SysUser();
    }

    @RequestMapping
    @ResponseBody
    @Transactional
    public void createUserVoTest() {
        UserVoTest userVoTest = new UserVoTest();
        userVoTest.setId(UUID.randomUUID().toString());
        UserVo userVo = new UserVo("1", "测试");
        userVoTest.setUserVo(userVo);
        userVoTest.setEmail("844497663@qq.com");
        entityManager.persist(userVoTest);
    }

    @RequestMapping("/getUserVoTest")
    @ResponseBody
    @Transactional
    public UserVoTest getUserVoTest() {
        UserVoTest userVoTest = entityManager.find(UserVoTest.class, "dcb9033c-8439-42a7-b670-677010e050f9");
        return userVoTest;
    }

    public static void main(String[] args) {
        UserServiceImpl userService1 = new UserServiceImpl();
//        CompletableFuture<String> stringCompletableFuture = userService1.asyncMethodA();
//        userService1.asyncMethodB(stringCompletableFuture);
        System.out.println(33333);
        String s = "id:1,class:A001;id:2,class:A002";
        String[] split = s.split(";");
        JSONArray jsonArray = new JSONArray();
        for (String str : split) {
//            String referenceString = JSON.toJSONString(str);
            String[] fields = str.split(",");
            for (String field : fields) {
                String id = field.split(":")[1];
                String clazz = field.split(":")[1];
                ObjectReference objectReference = new ObjectReference();
                objectReference.setId(id);
                objectReference.setClazz(clazz);
                jsonArray.add(objectReference);
            }
            System.out.println(jsonArray);
        }
    }

    @PostMapping("/getJsonArray")
    @ResponseBody
    @Transactional(timeout = 6000)
    public JSONArray getJsonArray() {
        String s = "id:1,class:A001;id:2,class:A002";
        String[] split = s.split(";");
        JSONArray jsonArray = new JSONArray();
        List<ObjectReference> list = new ArrayList<>();
        for (String str : split) {
//            String referenceString = JSON.toJSONString(str);
            String[] referClazz = str.split(",");
            String id = referClazz[0].split(":")[1];
            String clazz = referClazz[1].split(":")[1];
            ObjectReference objectReference = new ObjectReference();
            objectReference.setId(id);
            objectReference.setClazz(clazz);
            jsonArray.add(objectReference);
            Users users = new Users();
            users.setNameEn("A001");
            objectReference.setReferenceObject(users);
            list.add(objectReference);
            System.out.println(jsonArray);
        }
        Users user = new Users();
        user.setId(UUID.randomUUID().toString());
//        user.setName(JSON.toJSONString(list));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append("id" + ":" + list.get(i).getId());
            stringBuilder.append(",");
            stringBuilder.append("clazz" + ":" + list.get(i).getClazz());
            stringBuilder.append(";");
        }
        String result = list.stream()
                .map(ref -> "id:" + ref.getId() + ",clazz:" + ref.getClazz())
                .collect(Collectors.joining(";"));
        user.setName(result);
        user.setEmail(jsonArray.toJSONString());
        entityManager.merge(user);
        return jsonArray;
    }

    // 创建用户
    @PostMapping("/createUser")
    @ResponseBody
    @Transactional(timeout = 6000)
    public SysUser createUser(@RequestBody SysUser user) {
        test();
        SysUser sysUser = entityManager.merge(user);
        return sysUser;
//        User savedUser = userRepository.save(user);
//        JSONArray jsonArray = new JSONArray();
//        JSONObject json = (JSONObject)JSONObject.toJSON(user);
//        jsonArray.add(json);
//        PersistObject persistObject = new PersistObject();
//        persistObject.setJson(jsonArray);
//        PersistObject persistObject1= entityManager.merge(persistObject);
//        entityManager.find(SysUser.class, 1L);
//        Users user1 = entityManager.merge(user);
//        entityManager.flush();
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(user1.getId())
//                .toUri();
//        return ResponseEntity.created(location).body(user1);
    }
    
    private void test() {
        System.out.println("testJrebel");
    }
    
    // 更新用户信息
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users user) {
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    // 删除用户信息
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println(1111);
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/{userId}")
    public void TestHibernateCache(@PathVariable long userId) {
        // 假设 entityManager 是一个有效的 EntityManager 实例
        // 假设 userId 是我们想要查询的用户的 ID

        Users userProxy = entityManager.getReference(Users.class, userId);

        // 这时，userProxy 是一个 User 实体的代理对象，不是真实的实体

        // 访问 userProxy 的一个非 ID 属性，比如 name
        String userName = userProxy.getName();

        // 调用 getName() 将触发 JPA 去数据库中加载 userProxy 的真实数据
        // 因此，现在 userProxy 已经被填充了真实的 User 实体数据
//        System.out.println(userProxy.getId());
//        System.out.println(userName);
//        System.out.println(userName);
//        System.out.println(userProxy);
    }

}
