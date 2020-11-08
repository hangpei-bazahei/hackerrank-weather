package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherApiRestController {

    @Autowired
    WeatherService weatherService;


    @ResponseBody
    @RequestMapping(value = "/weather", method = {RequestMethod.POST})
    public String postWeather(@RequestBody List<Weather> weather){

        System.out.println("Posting Weather");
        weatherService.uploadWeatherData(weather);
        return "success";
    }

    @RequestMapping(value = "/weather/lat", method = {RequestMethod.GET})
    public String getWeatherByLat(){
        System.out.println("get Weather by latitude");
        return "success";
    }

    @RequestMapping(value = "/erase/date", method = {RequestMethod.DELETE})
    public String deleteWeatherByDate(){
        System.out.println("deleting Weather");
        return "success";
    }

    @RequestMapping(value = "/weather", method = {RequestMethod.GET})
    public String getWeather(){
        System.out.println("Posting Weather");
        return "success";
    }
}
