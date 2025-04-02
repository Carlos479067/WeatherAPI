package com.example.myownweather;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface WeatherRepository extends CrudRepository<Weather, String> {

    Optional<Weather> findByCity(String city); // custom method
}
