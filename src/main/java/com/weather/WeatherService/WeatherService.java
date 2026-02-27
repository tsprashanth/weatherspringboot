package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(double lat, double lon) {

        String pointsUrl = "https://api.weather.gov/points/" + lat + "," + lon;

        Map<String, Object> pointsResponse =
                restTemplate.getForObject(pointsUrl, Map.class);

        Map<String, Object> properties =
                (Map<String, Object>) pointsResponse.get("properties");

        String forecastUrl = (String) properties.get("forecast");

        Map<String, Object> forecastResponse =
                restTemplate.getForObject(forecastUrl, Map.class);

        Map<String, Object> forecastProps =
                (Map<String, Object>) forecastResponse.get("properties");

        List<Map<String, Object>> periods =
                (List<Map<String, Object>>) forecastProps.get("periods");

        Map<String, Object> today = periods.get(0);

        String shortForecast = (String) today.get("shortForecast");
        Integer temperature = (Integer) today.get("temperature");

        String category = categorizeTemperature(temperature);

        return new WeatherResponse(shortForecast, temperature, category);
    }

    private String categorizeTemperature(int temp) {
        if (temp >= 85) return "HOT";
        if (temp <= 50) return "COLD";
        return "MODERATE";
    }
}