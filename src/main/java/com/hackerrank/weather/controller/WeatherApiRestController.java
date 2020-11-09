package com.hackerrank.weather.controller;


import com.hackerrank.weather.model.Location;
import com.hackerrank.weather.model.Record;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.LocationRepository;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;
@Transactional
@RestController
public class WeatherApiRestController {

    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    LocationRepository locationRepository;

    @GetMapping(path = "/weather")
    public List<Weather> getAllWeather(){
        List<Weather> weatherList = weatherRepository.findAll();
        return weatherList;
    }

    @GetMapping(value = "/weather?lat={lat}&lon={lon}")
    public List<Weather> getWeatherByLatLon(@RequestParam("lat") float lat, @RequestParam("lon") float lon){
        Location location = locationRepository.findByLatAndLon(lat, lon);
        List<Weather> weatherList = weatherRepository.findByLocationCity(location.getCity());
        return weatherList;
    }


    @GetMapping(path = "/weather/temperature/")
    public List<Record> getTempRecordByDate(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        List<Weather> weatherList = weatherRepository.findByDateBetween(startDate, endDate);
        Map<String, Record> recordMap = new HashMap<>();
        // 1. Iterate all the Weather Object
        // 2. Save to a hashmap with Location:Record
        // 3. For each location, update the max and min temperature
        // 4. Convert HashMap to List of Record
        Record recordCursor;
        for(Weather weather: weatherList){
            Location location = weather.getLocation();
            String city = location.getCity();
            String[] dayTemperature = weather.getTemperature().split(",");
            float max = Float.MIN_VALUE;
            float min = Float.MAX_VALUE;
            for(String temp: dayTemperature){
                max = Math.max(max, Float.parseFloat(temp));
                min = Math.min(min, Float.parseFloat(temp));
            }
            if(recordMap.containsKey(city)){
                recordCursor = recordMap.get(city);

                if(max > recordCursor.getHighest())
                    recordCursor.setHighest(max);
                if(min < recordCursor.getLowest())
                    recordCursor.setLowest(min);
            } else {
                recordCursor = new Record(city, location.getState(), location.getLat(), location.getLon(), max, min);
                recordMap.put(city, recordCursor);
            }
        }
        List<Record> recordList = new ArrayList<>(recordMap.values());
        return recordList;
    }

    @PostMapping(path = "/weather")
    public String postWeather(@RequestBody Weather weather){
        weatherRepository.save(weather);
        return "success";
    }

    @DeleteMapping(path = "/erase")
    public String deleteAllWeather(){
        weatherRepository.deleteAll();
        return "success";
    }

    @DeleteMapping(value = "/delete")
    public String deleteByDateBetweenAndLocation(@RequestParam(name = "lat") float lat, @RequestParam(name = "lon") float lon, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        Location location = locationRepository.findByLatAndLon(lat, lon);
        if(location == null)
            return "Location Not Found";
        weatherRepository.deleteByDateBetweenAndLocationCity(startDate, endDate, location.getCity());
        return location.getCity();
    }

}
