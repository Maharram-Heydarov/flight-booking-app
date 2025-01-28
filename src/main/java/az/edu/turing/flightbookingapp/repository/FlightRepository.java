package az.edu.turing.flightbookingapp.repository;

import az.edu.turing.flightbookingapp.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {


    List<FlightEntity> findByDateAndTime(LocalDate date, LocalTime time);

    List<FlightEntity> findByDepartureLocation(String departureLocation);

    List<FlightEntity> findByDestinationLocation(String destinationLocation);

    Optional<FlightEntity> findById(Long id);

    @Query("SELECT f FROM FlightEntity f WHERE f.departureLocation = :departureLocation AND f.destinationLocation = :destinationLocation AND f.date = :date")
    List<FlightEntity> searchFlights(
            @Param("departureLocation") String departureLocation,
            @Param("destinationLocation") String destinationLocation,
            @Param("date") String date);

}
