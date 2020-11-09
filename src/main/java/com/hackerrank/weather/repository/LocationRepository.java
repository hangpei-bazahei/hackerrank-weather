package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {

    public Location findByLatAndLon(float lat, float lon);
}
