package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Location;
import com.hackerrank.weather.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    List<Weather> findAll();

    List<Weather> findByLocationCity(String location_city);

    void deleteByDateBetweenAndLocationCity(Date startDate, Date endDate, String location_city);

    List<Weather> findByDateBetween(Date startDate, Date endDate);
}
