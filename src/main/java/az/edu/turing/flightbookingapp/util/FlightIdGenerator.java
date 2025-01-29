package az.edu.turing.flightbookingapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(1000);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String generateFlightId(String airlineCode) {
        String datePart = LocalDate.now().format(DATE_FORMATTER);
        int sequence = counter.getAndIncrement();
        return airlineCode.toUpperCase() + "-" + datePart + "-" + sequence;
    }
}
