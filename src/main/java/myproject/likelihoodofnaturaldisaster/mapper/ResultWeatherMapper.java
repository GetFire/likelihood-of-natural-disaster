package myproject.likelihoodofnaturaldisaster.mapper;

import myproject.likelihoodofnaturaldisaster.dto.ForecastDto;
import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.entity.ResultWeather;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultWeatherMapper {
    ResultWeather map(ForecastDto s);

    ResultWeather map(ForecastDto s, GeoForm f);
}
