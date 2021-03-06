package com.hackerrank.weather.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "LOCATION_CITY")
    private Location location;

    private String temperature;

    public Weather() {
    }

    public Weather(Long id, Date dateRecorded, Location location, String temperature) {
        this.id = id;
        this.date = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateRecorded) {
        this.date = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
