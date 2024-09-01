package org.example.controller;

import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description:org.example.controller
 * @Date:2024/8/31
 * @Author:谢锦创
 */
@RestController
@RequestMapping("/transacation")
public class TransactionController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
//    @Transactional
    public List test() {
        try {
            return testService.selectTask();
        }   catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
