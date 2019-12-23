package myproject.likelihoodofnaturaldisaster.facade.impl;

import myproject.likelihoodofnaturaldisaster.dto.CustomerDto;
import myproject.likelihoodofnaturaldisaster.dto.ForecastDto;
import myproject.likelihoodofnaturaldisaster.facade.ForecastFacade;
import myproject.likelihoodofnaturaldisaster.model.CustomerModel;
import myproject.likelihoodofnaturaldisaster.service.CustomerService;
import myproject.likelihoodofnaturaldisaster.service.ForecastService;
import tk.plogitech.darksky.forecast.model.Forecast;

public class ForecastFacadeImpl implements ForecastFacade {
    private ForecastService forecastService;
    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto getForecast(String id) {
        CustomerModel customer = customerService.getCustomerForId(id);
        Forecast forecastForUser = forecastService.getForecastForUser(customer);
        customer.getForecastList().add(forecastForUser);
        return customerMapper.map(customer);
    }

    @Override
    public void saveForecast() {

    }

    @Override
    public ForecastDto getLastForecastForCustomer(CustomerDto customerDto) {
        return null;
    }

    public void setForecastService(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
