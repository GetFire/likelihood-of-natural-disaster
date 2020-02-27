package myproject.likelihoodofnaturaldisaster.test;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultWeatherRepository extends CrudRepository<ResultWeather,Integer> {
    @Query(value = "SELECT * FROM likelihood-of-natural-disaster-bd.result_weather where id=:id ")
    ResultWeather findById(@Param("id")int id);
}
