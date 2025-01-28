package az.edu.turing.flightbookingapp.controller;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.dto.BookingDto;
import az.edu.turing.flightbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/searchFlights")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @RequestParam String departureLocation,
            @RequestParam String destinationLocation,
            @RequestParam String date) {
        List<FlightDto> flights = userService.searchFlights(departureLocation, destinationLocation, date);
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/bookFlight")
    public ResponseEntity<BookingDto> bookFlight(
            @RequestParam Long flightId,
            @RequestParam Long userId) {
        BookingDto bookingDto = userService.bookFlight(flightId, userId);
        return ResponseEntity.ok(bookingDto);
    }

    @DeleteMapping("/cancelBooking")
    public ResponseEntity<Void> cancelBooking(
            @RequestParam Long bookingId,
            @RequestParam Long userId) {
        userService.cancelBooking(bookingId, userId);
        return ResponseEntity.noContent().build();
    }
}
