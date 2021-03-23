package optional;

public class InvalidCommandData extends Exception {
    public InvalidCommandData() {
        super("Unknown command.");
    }

    public InvalidCommandData(String s) {
        super(s);
    }
}
