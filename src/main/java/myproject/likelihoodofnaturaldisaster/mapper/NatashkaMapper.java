package myproject.likelihoodofnaturaldisaster.mapper;

import myproject.likelihoodofnaturaldisaster.dto.NatashkaOfigevashkaDto;
import myproject.likelihoodofnaturaldisaster.dto.TestDto1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

 @Mapper(componentModel = "spring")
public interface NatashkaMapper {

    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "city.cityName", target = "city")
    @Mapping(source = "city.country", target = "country")
    @Mapping(source = "addressDto.houseNumber",target = "houseNumb")
    @Mapping(source ="addressDto.street",target ="street")
    @Mapping(source ="addressDto.phone.number",target ="phone")
    //@Mapping(source ="addressDto.phoneNumber",target ="phone ")

    NatashkaOfigevashkaDto map (TestDto1 source);
}


