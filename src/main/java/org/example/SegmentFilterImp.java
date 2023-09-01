package org.example;

import java.util.List;
import java.util.Set;

public class SegmentFilterImp implements SegmentFilter {
//    фильтр на показать все сегменты
    @Override
    public void showAllSegments(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Flight segments - " + flight.getSegments());
        }

    }
//    Вылет до текущего момента времени
    @Override
    public Set<Flight> getFlightInTime(List<Flight> flights) {
        return null;
    }
//    Имеются сегменты с датой прилёта раньше даты вылета
    @Override
    public Set<Flight> getSegmentsEarlierThanDepartureDate(List<Flight> flights) {
        return null;
    }
//    Общее время, проведённое на земле превышает два часа
    @Override
    public Set<Flight> getFlightsExceedsTwoHoursInGround(List<Flight> flights) {
        return null;
    }
}
