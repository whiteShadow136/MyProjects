package org.example.controller;

import com.alibaba.fastjson.JSON;
import org.example.entity.SysUser;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    // 获取用户信息
    @GetMapping("/{id}")
    @ResponseBody
    public SysUser getUser(@PathVariable String id) throws ExecutionException, InterruptedException {
//        SysUser user = userService.getUser(id);
//        System.out.println(user);
        CompletableFuture<String> stringCompletableFuture = userService.asyncMethodA();
        userService.asyncMethodB(stringCompletableFuture);
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
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
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
