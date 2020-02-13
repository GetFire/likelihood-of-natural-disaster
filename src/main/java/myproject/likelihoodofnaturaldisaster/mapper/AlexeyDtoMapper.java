package myproject.likelihoodofnaturaldisaster.mapper;

import com.github.dvdme.ForecastIOLib.FIODataPoint;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlexeyDtoMapper {

    default AlexeyForecastDto map(FIODataPoint source) {
        AlexeyForecastDto target = new AlexeyForecastDto();
        target.setTime(source.time());
        target.setSummary(source.summary());
        target.setSunriseTime(source.sunriseTime());
        target.setSunsetTime(source.sunsetTime());
        target.setIcon(source.icon());
        target.setTimezone(source.getTimezone());
        target.setTemperatureMinTime(source.temperatureMinTime());
        target.setTemperatureMaxTime(source.temperatureMaxTime());
        target.setPrecipType(source.precipType());
        target.setApparentTemperatureMinTime(source.apparentTemperatureMinTime());
        target.setApparentTemperatureMaxTime(source.apparentTemperatureMaxTime());
        target.setPrecipIntensity(source.precipIntensity());
        target.setCloudCover(source.cloudCover());
        target.setHumidity(source.humidity());
        target.setNearestStormDistance(source.nearestStormDistance());
        target.setPrecipAccumulation(source.precipAccumulation());
        target.setPressure(source.pressure());
        target.setVisibility(source.visibility());
        target.setWindSpeed(source.windSpeed());
        return target;
    }

}
