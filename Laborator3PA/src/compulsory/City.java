package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private List<Location> nodes;
    private String cityName;

    public City(List<Location> nodes, String cityName) {
        this.nodes = nodes;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void showVisitableNotPayable() { // creates an arraylist of locations that are visitable, but not payable
        List<Location> locations = new ArrayList<>();
        for (Location node : nodes) {
            if (node instanceof Visitable && !(node instanceof Payable)) {
                locations.add(node);
            }
        }
        sortAndPrint(locations); // will sort and print the arraylist
    }

    private void sortAndPrint(List<Location> locations) { // sorts and prints the arraylist of locations based on the opening time ascending
        for (int i = 0; i < locations.size(); i++)
            for (int j = i + 1; j < locations.size(); j++) {
                if (((Visitable) locations.get(j)).getOpeningTime().isBefore(((Visitable) locations.get(i)).getOpeningTime())) {
                    Location aux = locations.get(i);
                    locations.set(i, locations.get(j));
                    locations.set(j, aux);
                }
            }
        for (Location location : locations) {
            System.out.println("Location " + location.getName() + " opens at " + ((Visitable) location).getOpeningTime());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return getNodes().equals(city.getNodes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNodes());
    }

    @Override
    public String toString() {
        return "City{ \nName:" + cityName +
                "\nnodes=" + nodes +
                "\n}";
    }
}
