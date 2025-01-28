package az.edu.turing.flightbookingapp.service;

import az.edu.turing.flightbookingapp.dto.UserDto;
import az.edu.turing.flightbookingapp.entity.UserEntity;

public interface AuthService {
    UserDto registerUser(UserDto userDto);
    String loginUser(String username, String password);
}
