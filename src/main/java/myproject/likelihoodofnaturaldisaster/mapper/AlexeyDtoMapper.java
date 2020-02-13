package myproject.likelihoodofnaturaldisaster.mapper;

import com.github.dvdme.ForecastIOLib.FIODataPoint;
import myproject.likelihoodofnaturaldisaster.dto.AlexeyForecastDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlexeyDtoMapper {
    AlexeyForecastDto sourceToDestination(FIODataPoint source);
    FIODataPoint destinationToSource(AlexeyForecastDto destination);
}
