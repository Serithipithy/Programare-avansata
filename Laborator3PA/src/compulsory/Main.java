package compulsory;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel();
        v1.setOpeningTime(LocalTime.of(6, 30));
        v1.setClosingTime(LocalTime.MIDNIGHT);
        v1.setTicketPrice(100);
        v1.setRank(2);
        v1.setName("Hotel");
        Museum v2 = new Museum();
        v2.setOpeningTime(LocalTime.of(10, 30)); //10:30
        v2.setClosingTime(LocalTime.parse("17:00"));
        v2.setTicketPrice(17);
        v2.setName("Museum A");
        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.of(9, 30)); //9:30
        v3.setClosingTime(LocalTime.parse("17:00"));
        v3.setTicketPrice(20);
        v3.setName("Museum B");
        Church v4 = new Church();
        v4.setOpeningTime(LocalTime.of(7, 0));
        v4.setClosingTime(LocalTime.MIDNIGHT);
        v4.setName("Church A");
        Church v5 = new Church();
        v5.setOpeningTime(LocalTime.of(6, 30));
        v5.setClosingTime(LocalTime.MIDNIGHT);
        v5.setName("Church B");
        Restaurant v6 = new Restaurant();
        v6.setOpeningTime(LocalTime.of(8, 0)); //10:30
        v6.setClosingTime(LocalTime.parse("22:00"));
        v6.setRank(1);
        v6.setName("Restaurant");
        v6.setTicketPrice(50.6);


        List<Location> myList = new ArrayList<>();
        myList= Arrays.asList(v1,v2,v3,v4,v5,v6);

        City myCity = new City(myList,"Iasi");
        System.out.println(myCity.toString());

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v4.setCost(v6,10);
        v5.setCost(v4,30);
        v5.setCost(v6,20);
//        v3.setCost(v2,20);
//        v4.setCost(v5,30);

//        System.out.println(myCity.toString());

    }

}
