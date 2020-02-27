package myproject.likelihoodofnaturaldisaster.test;

import java.util.List;

public interface ResultWeatherService {
    ResultWeather addWeatherResult(ResultWeather resultWeather);
    void delete(int id);
    ResultWeather editResultWeather(ResultWeather resultWeather);
    List<ResultWeather>getAll();
}
