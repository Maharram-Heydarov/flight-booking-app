package az.edu.turing.flightbookingapp.service.impl;

import az.edu.turing.flightbookingapp.dto.UserDto;
import az.edu.turing.flightbookingapp.entity.UserEntity;
import az.edu.turing.flightbookingapp.exception.UserNotFoundException;
import az.edu.turing.flightbookingapp.repository.UserRepository;
import az.edu.turing.flightbookingapp.security.JwtUtil;
import az.edu.turing.flightbookingapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity savedUser = userRepository.save(userEntity);
        return new UserDto(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword());
    }

    @Override
    public String loginUser(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(userEntity.getUsername());
    }
}