package myproject.likelihoodofnaturaldisaster.facade;

import myproject.likelihoodofnaturaldisaster.model.CustomerModel;
import tk.plogitech.darksky.forecast.model.Forecast;

public interface ForecastService {
    Forecast getForecastForUser(CustomerModel customerModel);
}
