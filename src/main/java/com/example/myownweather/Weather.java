package com.example.myownweather;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Optional;
import static java.lang.Math.round;

@Entity // Marks class as entity, representing a table in relational database
public class Weather {

    @Id // Marks field as primary key
    private String id;
    @JsonProperty("name")
    private String city;
    @JsonProperty("main")
    @Embedded
    private Main main;

    public Weather() {

    }
    public Weather(String id, String city) {
        this.id = id;
        this.city = city;
    }
    public static class Main {

        private double temp;
        private double humidity;

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getTemp() {
            temp = (temp - 273.15) * 9/5 + 32;
            return round(temp);
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return Optional.ofNullable(main)
                .map(Main::getTemp)
                .orElse(0.0);
    }




    // toString method
    @Override
    public String toString() {
        return "Weather { " +
                "City ID: " + id + " | " +
                "City Name: " + getCity() + " | " +
                "Temperature: " + main.getTemp() + " | " +
                "Humidity: " + main.getHumidity() + " | " +
                "}";
    }
}
