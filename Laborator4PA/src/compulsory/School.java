package compulsory;

public class School implements Comparable<School>{
    private String name;
    private int capacity;

    public School() {
    }

    public School(int capacity) {
        this.capacity = capacity;
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public int compareTo(School o) {
        return this.capacity - o.capacity;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
