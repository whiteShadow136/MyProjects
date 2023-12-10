package com.example.controller;

import org.example.weather.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WeatherController {

    @RequestMapping("/weather")
    public WeatherResponse getCurrentWeather(String location) {
        // 模拟的天气数据响应
        WeatherResponse response = new WeatherResponse();
        response.setLocation(location);
        response.setTemperature("23°C");
        response.setCondition("Sunny");
        return response;
    }
}
