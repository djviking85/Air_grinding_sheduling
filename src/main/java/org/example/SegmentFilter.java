package org.example;

import java.util.List;
import java.util.Set;

public interface SegmentFilter {
    void showAllSegments(List<Flight> flights);
    Set<Flight> getFlightInTime(List<Flight> flights);
    Set<Flight> getSegmentsEarlierThanDepartureDate(List<Flight> flights);
    Set<Flight> getFlightsExceedsTwoHoursInGround(List<Flight> flights);
}
