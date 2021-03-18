package compulsory;

public class InvalidCatalogData extends Exception {
    public InvalidCatalogData(String ex) {
        super("Invalid catalog data:" + ex);
    }

}
