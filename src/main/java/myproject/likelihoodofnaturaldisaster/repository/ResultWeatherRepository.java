package myproject.likelihoodofnaturaldisaster.repository;

import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultWeatherRepository extends JpaRepository<ResultWeather,Integer> {
}
