package compulsory;

import java.util.LinkedList;
import java.util.List;

public class TravelPlan {
    City cityName;
    List<Location> listPreferences;

    // constructor
    public TravelPlan(City cityName, List<Location> listPreferences) {
        this.cityName = cityName;
        this.listPreferences = new LinkedList<>();
        this.listPreferences = listPreferences;
    }

    // setters and getters
    public City getCityName() {
        return cityName;
    }

    public void setCityName(City name) {
        this.cityName = name;
    }

    public List<Location> getListPreferences() {
        return listPreferences;
    }

    public void setListPreferences(List<Location> listPreferences) {
        int i, j;
        for (i = 0; i < listPreferences.size(); i++) {
            for (j = 0; j < cityName.getNodes().size(); j++) {
                if (listPreferences.get(i).getName().equals(cityName.getNodes().get(j).getName())) {
                    j = cityName.getNodes().size() + 1;
                }
            }
            if (j == cityName.getNodes().size()) {
                System.out.println("Some locations are not in this city.");
                return;
            }
        }
        this.listPreferences = listPreferences;
    }

    // add a new location to the list
    public void addLocation(Location newLocation) {
        int j;
        for (j = 0; j < cityName.getNodes().size(); j++) {
            if (newLocation.getName().equals(cityName.getNodes().get(j).getName())) {
                j = cityName.getNodes().size() + 1;
            }
            if (j == cityName.getNodes().size()) {
                System.out.println("Some locations are not in this city.");
                return;
            }
            listPreferences.add(newLocation);
        }
    }
}
