package org.example.impl;

import org.example.service.WeatherServiceClient;
import org.example.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl {

    @Autowired
    private WeatherServiceClient weatherServiceClient;

    public WeatherResponse getCurrentWeather(String location) {
        return weatherServiceClient.getCurrentWeather(location);
    }
}
