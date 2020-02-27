package myproject.likelihoodofnaturaldisaster.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultWeatherRepo extends JpaRepository<ResultWeather,Integer> {

    @Query(value = "SELECT * FROM RESULT_WEATHER ")
}
