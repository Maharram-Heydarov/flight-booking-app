package az.edu.turing.flightbookingapp.mapper;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.entity.FlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDto toDto(FlightEntity entity);

    FlightEntity toEntity(FlightDto dto);
}
