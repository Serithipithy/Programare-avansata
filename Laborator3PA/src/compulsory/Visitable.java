package compulsory;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();

    default void openingTime(Church church){
        church.setOpeningTime(LocalTime.of(9, 30));
        church.setClosingTime(LocalTime.of(20, 0));
    }

    default void openingTime(Museum museum){
        museum.setOpeningTime(LocalTime.of(9, 30));
        museum.setClosingTime(LocalTime.of(20, 0));
    }

    default void openingTime(Restaurant restaurant){
        restaurant.setOpeningTime(LocalTime.of(9, 30));
        restaurant.setClosingTime(LocalTime.of(20, 0));
    }

    default void openingTime(Hotel hotel){
        hotel.setOpeningTime(LocalTime.of(9, 30));
        hotel.setClosingTime(LocalTime.of(20, 0));
    }

    static Duration getVisitingDuration(Location location){
        Duration duration = new Duration();
        LocalTime open= ((Visitable) location).getClosingTime().minusMinutes(((Visitable) location).getOpeningTime().getMinute());
        open = open.minusHours(((Visitable) location).getOpeningTime().getHour());
        duration.setHoursOpen(open);
        return duration;
    }
}
