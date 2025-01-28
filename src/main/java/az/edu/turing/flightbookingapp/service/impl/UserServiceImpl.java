package az.edu.turing.flightbookingapp.service.impl;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.dto.BookingDto;
import az.edu.turing.flightbookingapp.entity.FlightEntity;
import az.edu.turing.flightbookingapp.entity.BookingEntity;
import az.edu.turing.flightbookingapp.entity.UserEntity;
import az.edu.turing.flightbookingapp.exception.FlightNotFoundException;
import az.edu.turing.flightbookingapp.exception.UserNotFoundException;
import az.edu.turing.flightbookingapp.exception.BookingNotFoundException;
import az.edu.turing.flightbookingapp.mapper.FlightMapper;
import az.edu.turing.flightbookingapp.mapper.BookingMapper;
import az.edu.turing.flightbookingapp.repository.FlightRepository;
import az.edu.turing.flightbookingapp.repository.BookingRepository;
import az.edu.turing.flightbookingapp.repository.UserRepository;
import az.edu.turing.flightbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper,
                           BookingRepository bookingRepository, BookingMapper bookingMapper,
                           UserRepository userRepository) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<FlightDto> searchFlights(String departureLocation, String destinationLocation, String date) {
        return flightRepository.searchFlights(departureLocation, destinationLocation, date)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto bookFlight(Long flightId, Long userId) {
        FlightEntity flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + flightId + " not found"));
        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats for flight with ID " + flightId);
        }
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
        BookingEntity booking = new BookingEntity();
        booking.setFlight(flight);
        booking.setUser(user);
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);
        BookingEntity savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    public void cancelBooking(Long bookingId, Long userId) {
        BookingEntity booking = bookingRepository.findByIdAndUserId(bookingId, userId)
                .orElseThrow(() -> new BookingNotFoundException("Booking with ID " + bookingId + " not found for user with ID " + userId));
        FlightEntity flight = booking.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        flightRepository.save(flight);
        bookingRepository.delete(booking);
    }
}