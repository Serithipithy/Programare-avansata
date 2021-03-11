package compulsory;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime() {
        return (LocalTime.of(9, 30));
    }

    default LocalTime getClosingTime() {
        return (LocalTime.of(20, 0));
    }

    static Duration getVisitingDuration(Location location){ // returns a Duration object that has the opening time of a Visitable object
        Duration duration = new Duration();
        LocalTime open= ((Visitable) location).getClosingTime().minusMinutes(((Visitable) location).getOpeningTime().getMinute()); // closingHour:closingMinutes - 0:openingMinutes
        open = open.minusHours(((Visitable) location).getOpeningTime().getHour()); // closingHour:closingMinutes - openingHour:0
        duration.setHoursOpen(open);
        return duration;
    }

}
