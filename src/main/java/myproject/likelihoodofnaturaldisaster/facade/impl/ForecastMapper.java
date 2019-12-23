package myproject.likelihoodofnaturaldisaster.facade.impl;

import myproject.likelihoodofnaturaldisaster.dto.ForecastDto;
import tk.plogitech.darksky.forecast.model.Forecast;

import java.util.ArrayList;
import java.util.List;

public class ForecastMapper {

    public List<Forecast> mapList(List<Forecast> forecastList) {
        List<ForecastDto> result = new ArrayList<>(forecastList.size());
        for (Forecast forecast : forecastList) {
            ForecastDto toAdd = new ForecastDto();
            toAdd.setAlerts(forecast.getAlerts());

        }
        return result;
    }
}
