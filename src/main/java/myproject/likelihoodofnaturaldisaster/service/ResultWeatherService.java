package myproject.likelihoodofnaturaldisaster.service;

import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;

import java.util.List;

public interface ResultWeatherService {
    ResultWeather addWeatherResult(ResultWeather resultWeather);

    void delete(ResultWeather toDelete);

    ResultWeather editResultWeather(ResultWeather resultWeather);

    List<ResultWeather> getAll();
}
