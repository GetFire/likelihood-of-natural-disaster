package myproject.likelihoodofnaturaldisaster.service.impl;

import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;
import myproject.likelihoodofnaturaldisaster.repository.ResultWeatherRepository;
import myproject.likelihoodofnaturaldisaster.service.ResultWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultWeatherServiceImpl implements ResultWeatherService {
    @Autowired
    private ResultWeatherRepository resultWeatherRepo;


    @Override
    public ResultWeather addWeatherResult(ResultWeather resultWeather) {
        ResultWeather savedResultWeather = resultWeatherRepo.saveAndFlush(resultWeather);
        return savedResultWeather;
    }

    @Override
    public void delete(ResultWeather toDelete) {
        resultWeatherRepo.delete(toDelete);

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
