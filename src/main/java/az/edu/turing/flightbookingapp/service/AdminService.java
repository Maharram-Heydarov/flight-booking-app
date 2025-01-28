package az.edu.turing.flightbookingapp.service;

import az.edu.turing.flightbookingapp.dto.FlightDto;

public interface AdminService {
    FlightDto addFlight(FlightDto flightDto);
    FlightDto updateFlight(Long id, FlightDto flightDto);
    void deleteFlight(Long id);
}
