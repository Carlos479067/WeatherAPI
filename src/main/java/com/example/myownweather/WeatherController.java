package com.example.myownweather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/city")
    public String getWeather(@RequestParam String city) {
        Weather weather = weatherService.getWeather(city);
        return weather.toString();
    }

}
