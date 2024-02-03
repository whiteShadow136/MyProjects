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

    List<Integer> list = new ArrayList<>();

//    @Test
    public static void main(String[] args) {
        ApplicationTests applicationTests = new ApplicationTests();
        applicationTests.testMulThread();
    }

    void testMulThread() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
//        CopyOnWriteArrayList<Integer> writeArrayList = new CopyOnWriteArrayList<>();
        list.addAll(arrayList);
//        list = writeArrayList;
        new Thread(() -> {
            test1(list);
        }).start();
        new Thread(() -> {
            test1(list);
        }).start();
//        list.add(5);
    }

    void test1(List<Integer> list) {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer o : list) {
            System.out.println(o);
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testSomeServiceMethod() {
        // 使用someService
    }
}
