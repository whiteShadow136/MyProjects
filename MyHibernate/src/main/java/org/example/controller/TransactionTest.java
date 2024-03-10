package org.example.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/test1")
    @ResponseBody
    @Transactional
    public void test1() {

    }

    @RequestMapping("/test2")
    @ResponseBody
    @Transactional
    public void test2() {

    }
}
