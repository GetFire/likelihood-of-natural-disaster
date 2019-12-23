package myproject.likelihoodofnaturaldisaster.facade.impl;

import myproject.likelihoodofnaturaldisaster.dto.CustomerDto;
import myproject.likelihoodofnaturaldisaster.model.CustomerModel;

public class CustomerMapper {

    private ForecastMapper forecastMapper;

    CustomerDto map(CustomerModel source){
        CustomerDto target = new CustomerDto();
        target.setLogin(source.getLogin());
        target.setName(source.getName());
        target.setForecastList(forecastMapper.mapList(source.getForecastList()));
        return target;
    }
}
