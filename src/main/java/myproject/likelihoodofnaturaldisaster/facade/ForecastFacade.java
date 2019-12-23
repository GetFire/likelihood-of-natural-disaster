package myproject.likelihoodofnaturaldisaster.facade;

import myproject.likelihoodofnaturaldisaster.dto.CustomerDto;
import myproject.likelihoodofnaturaldisaster.dto.ForecastDto;

public interface ForecastFacade {
    CustomerDto getForecast(String id);

    void saveForecast();

    ForecastDto getLastForecastForCustomer(CustomerDto customerDto);
}
