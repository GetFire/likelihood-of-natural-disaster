package myproject.likelihoodofnaturaldisaster.service;

import myproject.likelihoodofnaturaldisaster.model.CustomerModel;
import tk.plogitech.darksky.forecast.model.Forecast;

public interface ForecastService {
    Forecast getForecastForUser(CustomerModel customerModel);
}
