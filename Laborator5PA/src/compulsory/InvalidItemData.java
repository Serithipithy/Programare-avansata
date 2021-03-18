package compulsory;

public class InvalidItemData extends Exception {
    public InvalidItemData(String ex) {
        super("Invalid item data:" + ex);
    }
}
