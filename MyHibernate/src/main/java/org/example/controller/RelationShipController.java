package org.example.controller;

import org.example.relationship.RelationShipService;
import org.example.util.RocketMqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:org.example.controller
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@RestController
public class RelationShipController {

    @Autowired
    RelationShipService relationShipService;

    @Autowired(required = false)
    RocketMqUtil rocketMqUtil;

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        RelationShipService.putData();
//        rocketMqUtil.send("AAA", "AAA");
//        relationShipService.refreshCache();
    }

}
