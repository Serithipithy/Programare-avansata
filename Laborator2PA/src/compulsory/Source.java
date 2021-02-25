package compulsory;

public class Source {

    public enum SourceType {
        WAREHOUSE, FACTORY
    }

    private String name;
    private SourceType type;

    public Source() {
    }


    public Source(String name, SourceType type) {
        this.name = name;
        this.setType(type);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return name;
    }
}
