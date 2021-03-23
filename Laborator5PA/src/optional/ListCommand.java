package optional;

import compulsory.Catalog;

public class ListCommand extends Command {

    public ListCommand(String arguments, Catalog catalog) {
        super(arguments, catalog);
    }

    public void executeCommand() {
        for (int i = 0; i < this.catalog.getItems().size(); i++) {
            System.out.println("Item " + (i + 1) + " : '" +
                    this.catalog.getItems().get(i).getName() + "' has the location: " +
                    this.catalog.getItems().get(i).getLocation() + ", " +
                    this.catalog.getItems().get(i).toString());
        }
    }
}
