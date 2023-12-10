package org.example.controller;

import org.example.impl.WeatherServiceImpl;
import org.example.service.WeatherServiceClient;
import org.example.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:org.example.controller
 * @Date:2023/12/10
 * @Author:谢锦创
 */
@RestController
public class TestFeignController {

    @Autowired
    WeatherServiceImpl weatherService;

    @RequestMapping("/test")
    public String test(){
        WeatherResponse weather = weatherService.getCurrentWeather("china");
        return weather.toString();
    }
}
