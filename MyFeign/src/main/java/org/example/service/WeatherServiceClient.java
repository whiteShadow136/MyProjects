package org.example.service;

import org.example.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "weather-service", url = "http://euk1.com:8089")
public interface WeatherServiceClient {

//    @GetMapping("/current.json?key=YOUR_API_KEY&query={location}")
    @PostMapping("/weather")
    WeatherResponse getCurrentWeather(@PathVariable("location") String location);
}
