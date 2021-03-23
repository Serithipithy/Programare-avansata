package optional;

import compulsory.*;

public class AddCommand extends Command {
    public AddCommand(String arguments, Catalog catalog) {
        super(arguments, catalog);
    }

    public void executeCommand() throws InvalidCommandData, InvalidItemData {
        int type = getItemType();
        if (type == 0) {
            throw new InvalidCommandData("Unknown file type");
        } else if (type == 1) {
            String[] str;
            str = arguments.split(" ", 5);
            if (str[4] == null) throw new InvalidCommandData("Not enough arguments");

            Item localBook = new Book(str[0], str[1], str[4], str[2], Integer.parseInt(str[3]));
            catalog.add(localBook);
        } else {
            String[] str;
            str = arguments.split(" ", 7);
            if (str[5] == null) throw new InvalidCommandData("Not enough arguments");

            Item localMovie = new Movie(str[0], str[1], str[5], Integer.parseInt(str[2]), Integer.parseInt(str[3]), str[4]);
            catalog.add(localMovie);
        }
    }
}
