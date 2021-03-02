package compulsory;

import java.util.Objects;

public class Destination {
    private String name;

    public Destination() {

    }

    public Destination(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination that = (Destination) o;
        return name.equals(that.name);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
