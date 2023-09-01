package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime departure, final LocalDateTime arriv) {
        departureDate = Objects.requireNonNull(departure);
        arrivalDate = Objects.requireNonNull(arriv);

    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }
    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
