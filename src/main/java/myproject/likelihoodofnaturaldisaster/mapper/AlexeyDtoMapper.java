package myproject.likelihoodofnaturaldisaster.mapper;

import com.github.dvdme.ForecastIOLib.FIODataPoint;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AlexeyDtoMapper {
    @Mappings({
            @Mapping(target = "time", expression = "java(s.time())"),
            @Mapping(target = "summary", expression = "java(s.summary())"),
            @Mapping(target = "sunriseTime", expression = "java(s.sunriseTime())"),
            @Mapping(target = "sunsetTime", expression = "java(s.sunsetTime())"),
            @Mapping(target = "icon", expression = "java(s.icon())"),
            @Mapping(target = "temperatureMinTime", expression = "java(s.temperatureMinTime())"),
            @Mapping(target = "temperatureMaxTime", expression = "java(s.temperatureMaxTime())"),
            @Mapping(target = "precipType", expression = "java(s.precipType())"),
            @Mapping(target = "apparentTemperatureMinTime", expression = "java(s.apparentTemperatureMinTime())"),
            @Mapping(target = "apparentTemperatureMaxTime", expression = "java(s.apparentTemperatureMaxTime())"),
            @Mapping(target = "precipIntensity", expression = "java(s.precipIntensity())"),
            @Mapping(target = "cloudCover", expression = "java(s.cloudCover())"),
            @Mapping(target = "humidity", expression = "java(s.humidity())"),
            @Mapping(target = "nearestStormDistance", expression = "java(s.nearestStormDistance())"),
            @Mapping(target = "precipAccumulation", expression = "java(s.precipAccumulation())"),
            @Mapping(target = "pressure", expression = "java(s.pressure())"),
            @Mapping(target = "visibility", expression = "java(s.visibility())"),
            @Mapping(target = "windSpeed", expression = "java(s.windSpeed())"),
    })
    AlexeyForecastDto map(FIODataPoint s);
}

