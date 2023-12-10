package org.example.weather;

import lombok.Data;

/**
 * @Description:org.example.weather
 * @Date:2023/12/10
 * @Author:谢锦创
 */
@Data
public class WeatherResponse {
    public String condition;

    public String temperature;

    public String location;
}
