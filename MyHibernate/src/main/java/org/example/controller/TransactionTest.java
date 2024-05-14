package org.example.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;

/**
 * @Description:org.example.controller
 * @Date:2024/3/10
 * @Author:谢锦创
 */
@Controller
@RequestMapping("/transacation")
public class TransactionTest {

    @RequestMapping("/test2")
    @ResponseBody
    @Transactional
    public void test2() {
        System.out.println(TransactionAspectSupport.currentTransactionStatus());
        System.out.println(111);
    }
}
