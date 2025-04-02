package com.example.myownweather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.base.url}")
    private String apiUrl;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Weather getWeather(String city) {
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);

        // Fetch weather data from the API and map it to the Weather object
        Weather weather = restTemplate.getForObject(url, Weather.class);

        if (weather == null) {
            return null;  // If no data is found
        }

        // Save the weather data to the repository
        weatherRepository.save(weather);

        return weather;
    }
}



