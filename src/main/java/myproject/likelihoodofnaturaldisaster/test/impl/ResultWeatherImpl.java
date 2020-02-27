package myproject.likelihoodofnaturaldisaster.test.impl;

import myproject.likelihoodofnaturaldisaster.test.ResultWeather;
import myproject.likelihoodofnaturaldisaster.test.ResultWeatherRepo;
import myproject.likelihoodofnaturaldisaster.test.ResultWeatherRepository;
import myproject.likelihoodofnaturaldisaster.test.ResultWeatherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultWeatherImpl implements ResultWeatherService {
    @Autowired
    private ResultWeatherRepo resultWeatherRepo;
    private ResultWeatherRepository resultWeatherRepository;

    @Override
    public ResultWeather addWeatherResult(ResultWeather resultWeather) {
        ResultWeather savedResultWeather = resultWeatherRepo.saveAndFlush(resultWeather);
        return savedResultWeather;
    }

    @Override
    public void delete(int id) {
//        resultWeatherRepo.delete();

    }

    @Override
    public ResultWeather editResultWeather(ResultWeather resultWeather) {
        return resultWeatherRepo.saveAndFlush(resultWeather);
    }

    @Override
    public List<ResultWeather> getAll() {
        return resultWeatherRepo.findAll();
    }
}
