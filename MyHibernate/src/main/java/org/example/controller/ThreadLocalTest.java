package org.example.controller;

import org.example.entity.MyEntity;
import org.example.service.TestService;
import org.example.thread.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:org.example.controller
 * @Date:2024/8/7
 * @Author:谢锦创
 */
@RestController
@RequestMapping("threadLocal")
public class ThreadLocalTest {

    @Autowired
    TestService testService;

    // 新开一个线程，测试新的线程获取的数据是否和当前线程的一样
    @RequestMapping("testGetValue")
    public String testGetValue() {
        testService.asyncOfThreadLocal();
        ThreadLocalUtil.set(new MyEntity());
        return "SUCCESS";
    }
}
