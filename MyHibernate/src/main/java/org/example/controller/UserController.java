package org.example.controller;

import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    // 获取用户信息
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 创建用户
    @PostMapping
    @Transactional(timeout = 6000)
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        
//        User savedUser = userRepository.save(user);
//        JSONArray jsonArray = new JSONArray();
//        JSONObject json = (JSONObject)JSONObject.toJSON(user);
//        jsonArray.add(json);
//        PersistObject persistObject = new PersistObject();
//        persistObject.setJson(jsonArray);
//        PersistObject persistObject1= entityManager.merge(persistObject);
        entityManager.find(Users.class, 1L);
        Users user1 = entityManager.merge(user);
        entityManager.flush();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user1.getId())
                .toUri();
        return ResponseEntity.created(location).body(user1);
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
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}")
    public void TestHibernateCache(@PathVariable long userId) {
        // 假设 entityManager 是一个有效的 EntityManager 实例
        // 假设 userId 是我们想要查询的用户的 ID

        Users userProxy = entityManager.getReference(Users.class, userId);

        // 这时，userProxy 是一个 User 实体的代理对象，不是真实的实体

        // 访问 userProxy 的一个非 ID 属性，比如 name
        String userName = userProxy.getName();

        // 调用 getName() 将触发 JPA 去数据库中加载 userProxy 的真实数据
        // 因此，现在 userProxy 已经被填充了真实的 User 实体数据
        System.out.println(userProxy.getId());
//        System.out.println(userName);
//        System.out.println(userName);
//        System.out.println(userProxy);
    }

}
