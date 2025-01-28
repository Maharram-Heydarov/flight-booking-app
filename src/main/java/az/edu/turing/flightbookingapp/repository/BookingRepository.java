package az.edu.turing.flightbookingapp.repository;

import az.edu.turing.flightbookingapp.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {


    List<BookingEntity> findByUserId(Long userId);

    List<BookingEntity> findByFlightId(Long flightId);

    @Query("SELECT b FROM BookingEntity b WHERE b.id = :bookingId AND b.user.id = :userId")
    Optional<BookingEntity> findByIdAndUserId(
            @Param("bookingId") Long bookingId,
            @Param("userId") Long userId);
}
