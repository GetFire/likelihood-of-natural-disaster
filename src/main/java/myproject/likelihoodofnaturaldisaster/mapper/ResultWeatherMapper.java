package myproject.likelihoodofnaturaldisaster.mapper;

import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import myproject.likelihoodofnaturaldisaster.test.ResultWeather;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultWeatherMapper {

    ResultWeather map (AlexeyForecastDto s);

}
