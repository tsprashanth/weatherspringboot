package com.example.weather.model;

public class WeatherResponse {

    private String shortForecast;
    private int temperature;
    private String temperatureCategory;

    public WeatherResponse(String shortForecast, int temperature, String temperatureCategory) {
        this.shortForecast = shortForecast;
        this.temperature = temperature;
        this.temperatureCategory = temperatureCategory;
    }

    public String getShortForecast() {
        return shortForecast;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getTemperatureCategory() {
        return temperatureCategory;
    }
}