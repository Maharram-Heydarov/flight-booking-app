package az.edu.turing.flightbookingapp.service;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.dto.BookingDto;

import java.util.List;

public interface UserService {
    List<FlightDto> searchFlights(String departureLocation, String destinationLocation, String date);
    BookingDto bookFlight(Long flightId, Long userId);
    void cancelBooking(Long bookingId, Long userId);
}
