

import org.example.Flight;
import org.example.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {
    //    создаем полеты
    public List<Flight> createFlihgts() {
        LocalDateTime fourDaysBeforeFlight = LocalDateTime.now().plusDays(4);
        return  Arrays.asList(
                //Полет, который идет 2 часа
                createFlight(fourDaysBeforeFlight, fourDaysBeforeFlight.plusHours(2)),
                //Рейс, который отправляется раньше, чем прибывает
                createFlight(fourDaysBeforeFlight, fourDaysBeforeFlight.minusHours(6)),
                //Полет продолжительностью более двух часов на земле
                createFlight(fourDaysBeforeFlight, fourDaysBeforeFlight.plusHours(2),
                        fourDaysBeforeFlight.plusHours(5), fourDaysBeforeFlight.plusHours(6)),
                //Еще один рейс с более чем двумя часами наземного времени - ожидание
                createFlight(fourDaysBeforeFlight, fourDaysBeforeFlight.plusHours(2),
                        fourDaysBeforeFlight.plusHours(3), fourDaysBeforeFlight.plusHours(4),
                        fourDaysBeforeFlight.plusHours(6), fourDaysBeforeFlight.plusHours(7)),
                //Обычный рейс
                createFlight(fourDaysBeforeFlight, fourDaysBeforeFlight.plusHours(2),
                        fourDaysBeforeFlight.plusHours(3), fourDaysBeforeFlight.plusHours(5)));

    }

    protected Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "вы должны передать точную дату");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}
