package org.example;

import org.example.relationship.RelationShipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RelationShipService relationShipService;

    List list = new ArrayList();

    @Test
    public void contextLoads() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        new Thread(() -> {
            for (Object o : list) {
                System.out.println(1111);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        list.add(5);
        new Thread(() -> {
            for (Object o : list) {
                System.out.println(1111);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    @Test
    public void testSomeServiceMethod() {
        // 使用someService
    }
}
