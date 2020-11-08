package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;

import java.util.List;

public interface WeatherService {
    void uploadWeatherData(List<Weather> weather);
}
