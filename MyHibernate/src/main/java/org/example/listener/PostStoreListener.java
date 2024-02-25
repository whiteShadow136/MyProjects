package org.example.listener;

import org.example.entity.Users;
import org.example.event.PostStoreEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * @Description:org.example.listener
 * @Date:2024/1/30
 * @Author:谢锦创
 */
@Component
public class PostStoreListener implements ApplicationListener<PostStoreEvent> {

    @Autowired
    private EntityManager entityManager;
    @Override
    public void onApplicationEvent(PostStoreEvent event) {
        Users users = new Users();
        users.setId(UUID.randomUUID().toString());
        users.setName("test");
        entityManager.merge(users);
        Object source = event.getSource();
        System.out.println(source);
    }
}
