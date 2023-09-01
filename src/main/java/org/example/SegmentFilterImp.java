package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
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
        LocalDateTime timeNow = LocalDateTime.now();
        Set<Flight> result = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight: flights) {
            split.addAll(flight.getSegments());
            while (split.size() > 0) {
                LocalDateTime depDataTime = (split.get(0).getDepartureDate());
                LocalDateTime arrivDataTime = (split.remove(0).getDepartureDate());
                if (depDataTime.isAfter(timeNow)) {
                    showFlights(flight, depDataTime, arrivDataTime);
                    result.add(flight);
                }
            }
        }
        return result;
    }
//    Имеются сегменты с датой прилёта раньше даты вылета
    @Override
    public Set<Flight> getSegmentsEarlierThanDepartureDate(List<Flight> flights) {
        Set<Flight> result = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());

            while (split.size() > 0) {
                LocalDateTime departureDateTime = split.get(0).getDepartureDate();
                LocalDateTime arrivalDateTime = split.remove(0).getArrivalDate();
                if(arrivalDateTime.isBefore(departureDateTime)) {
                    showFlights(flight, departureDateTime, arrivalDateTime);
                    result.add(flight);
                }
            }

        }
        return result;
    }
//    Общее время, проведённое на земле превышает два часа
    @Override
    public Set<Flight> getFlightsExceedsTwoHoursInGround(List<Flight> flights) {
        Set<Flight> result = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());
            if (split.size() > 2) {
                while (split.size() > 2) {
                    LocalDateTime arrivalDateTime = split.remove(1).getArrivalDate();
                    LocalDateTime departureDateTime = split.remove(1).getDepartureDate();
                    if(departureDateTime.isAfter(arrivalDateTime.plusHours(2))) {
                        showTransfer(flight, arrivalDateTime, departureDateTime);
                        result.add(flight);
                    }
                }
            }
        }
        return result;
    }
//смотрим полеты
    private void showFlights(Flight flight, LocalDateTime depDataTime, LocalDateTime arrivDataTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormat();
        System.out.println( "Сегменты полетов - " + flight.getSegments()  + "\n" + "Время отбытия: " + dateTimeFormatter.format(depDataTime) + "\n" + "время прибытия: " + dateTimeFormatter.format(arrivDataTime) );
        System.out.println(" ^_^ ");
    }
//    смотрим трансфер
    private void showTransfer(Flight flight, LocalDateTime arrivDataTime, LocalDateTime depDataTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormat();
        System.out.println( "Flight segments - " + flight.getSegments()  + "\n" + "время прибытия: " + dateTimeFormatter.format(arrivDataTime) + "\n" + "Время отбытия: " + dateTimeFormatter.format(depDataTime)  );
        System.out.println(" O_O ");
    }
//паттерны на показ времени
    private DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }
}
