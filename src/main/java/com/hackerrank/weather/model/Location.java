package com.hackerrank.weather.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Location implements Serializable {

    @Id
    private String city;
    private String state;
    @Column(precision = 4)
    private Float lat;
    @Column(precision = 4)
    private Float lon;
//    @Id
//    @GeneratedValue
//    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Weather> weatherList;


    public Location() {
    }

    public Location(Long id, String city, String state, Float lat, Float lon) {

        //this.id = id;
        this.city = city;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
