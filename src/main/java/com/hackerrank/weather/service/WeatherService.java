package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Location;
import com.hackerrank.weather.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {
    public void uploadWeatherData(List<Weather> weather);
    public List<Weather> getWeatherByLocation(Location location);
    public void deleteAllWeather();
    public void deleteWeatherByDateAndLocation(Location location, Date date);
    public void getAllWeather();

}
