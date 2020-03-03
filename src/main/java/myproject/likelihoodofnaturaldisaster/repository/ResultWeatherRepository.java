package myproject.likelihoodofnaturaldisaster.repository;

import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultWeatherRepository extends JpaRepository<ResultWeather,Integer> {
}
