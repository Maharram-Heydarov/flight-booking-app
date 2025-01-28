package az.edu.turing.flightbookingapp.mapper;

import az.edu.turing.flightbookingapp.dto.UserDto;
import az.edu.turing.flightbookingapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);
}
