package com.hackerrank.weather.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class Record implements Serializable {

    private String city;
    private String state;
    private Float lat;
    private Float lon;
    private Float highest;
    private Float lowest;

    public Record() {
    }

    public Record(String city, String state, Float lat, Float lon, Float highest, Float lowest) {
        this.city = city;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
        this.highest = highest;
        this.lowest = lowest;
    }

    @Override
    public String toString() {
        return "{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", highest=" + highest +
                ", lowest=" + lowest +
                '}';
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

    public Float getHighest() {
        return highest;
    }

    public void setHighest(Float highest) {
        this.highest = highest;
    }

    public Float getLowest() {
        return lowest;
    }

    public void setLowest(Float lowest) {
        this.lowest = lowest;
    }



}
