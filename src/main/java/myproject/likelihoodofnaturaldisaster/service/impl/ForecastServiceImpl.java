package myproject.likelihoodofnaturaldisaster.service.impl;

import myproject.likelihoodofnaturaldisaster.model.CustomerModel;
import myproject.likelihoodofnaturaldisaster.service.ForecastService;
import tk.plogitech.darksky.forecast.model.Forecast;

public class ForecastServiceImpl implements ForecastService {

    @Override
    public Forecast getForecastForUser(CustomerModel customerModel) {
        Forecast forecast = new Forecast();
        customerModel.getForecastList().add(forecast);
        return forecast;
    }
}
