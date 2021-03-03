package compulsory;

import java.util.Objects;

abstract class Source {

    public String name;

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getType();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return getName().equals(source.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
