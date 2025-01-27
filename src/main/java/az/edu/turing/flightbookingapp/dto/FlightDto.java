package az.edu.turing.flightbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Long id;
    private String departureLocation;
    private String destinationLocation;
    private LocalDate date;
    private LocalTime time;
    private int availableSeats;
}

