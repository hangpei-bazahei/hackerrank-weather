package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Location;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void uploadWeatherData(List<Weather> weather) {
        weatherRepository.save(weather);
    }

    @Override
    public void deleteWeatherByDateAndLocation(Location location, Date date) {

    }

    @Override
    public List<Weather> getWeatherByLocation(Location location) {
        return null;
    }

    @Override
    public void deleteAllWeather() {

    }

    @Override
    public void getAllWeather() {

    }
}
