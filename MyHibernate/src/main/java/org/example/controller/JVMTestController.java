package org.example.controller;

import org.example.TestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:org.example.controller
 * @Date:2024/8/5
 * @Author:谢锦创
 */
@RestController
@RequestMapping("jvm")
public class JVMTestController {

    // 观察jvm堆中TestEntity实例的数量，每调用一次接口，就会新增1000个实例在堆中，
    // 引用虽然被回收了，但是堆中的数据没有被回收，一旦调用的次数多了，就会频繁触发垃圾回收。
    @RequestMapping("addObject")
    public String TestAddObject() {
        int number = 1000;
        for (int i = 0; i < number; i++) {
            TestEntity redisTest = new TestEntity("MyEntity");
        }
        return String.format("新增了%s个实例", number);
    }
}
