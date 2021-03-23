package optional;

import compulsory.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {

    public SaveCommand(String arguments, Catalog catalog) {
        super(arguments, catalog);
    }

    public void executeCommand() {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
