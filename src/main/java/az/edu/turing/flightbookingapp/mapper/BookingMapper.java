package az.edu.turing.flightbookingapp.mapper;

import az.edu.turing.flightbookingapp.dto.BookingDto;
import az.edu.turing.flightbookingapp.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "flight.id", target = "flightId")
    BookingDto toDto(BookingEntity entity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "flightId", target = "flight.id")
    BookingEntity toEntity(BookingDto dto);
}
