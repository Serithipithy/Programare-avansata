package compulsory;

import java.util.Objects;

public class Warehouse extends Source {
    private static final String type = "Warehouse";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

}
