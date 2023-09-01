package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlihgts();
        SegmentFilter segmentFilter = new SegmentFilterImp();
        segmentFilter.showAllSegments(flightList);
        System.out.println("-⚑-");
        System.out.println("Фильтр-1. Сегменты с вылетом до текущего момента времени");
        System.out.println("-⚑-");
        segmentFilter.getFlightInTime(flightList);

        System.out.println("-\uD83D\uDEE9-");
        System.out.println("Фильтр-2. Сегменты с датой прилёта раньше даты вылета");
        System.out.println("-\uD83D\uDEE9-");
        segmentFilter.getSegmentsEarlierThanDepartureDate(flightList);

        System.out.println("-\uD83D\uDEEC-");
        System.out.println("Фильтр-3. Общее время, проведённое на земле превышает два час");
        System.out.println("-\uD83D\uDEEC-");
        segmentFilter.getFlightsExceedsTwoHoursInGround(flightList);
    }
}