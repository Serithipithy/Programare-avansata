package compulsory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Location implements Comparable<Location>
{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    //… constructors, getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }
    //… toString, etc.

    @Override
    public String toString() {
        return "\nLocation{" +
                "name='" + name + '\'' +
                ", cost=" + convertWithStream(cost) +
                "}";
    }

    public String convertWithStream(Map<Location,Integer> map) {
        return map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return getName().equals(location.getName()) && getCost().equals(location.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCost());
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }

    public static int compare(Location a, Location b){
        return ((Visitable) a).getOpeningTime().compareTo(((Visitable) b).getOpeningTime());
    }

}
