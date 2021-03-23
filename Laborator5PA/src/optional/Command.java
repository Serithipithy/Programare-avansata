package optional;

import compulsory.Catalog;

abstract class Command {
    String arguments;
    Catalog catalog;

    public Command(String arguments, Catalog catalog) {
        this.arguments = arguments;
        this.catalog = catalog;
    }

    public int getItemType() { // get item type (1-for book, 2-for movie)
        if (arguments.endsWith(".pdf")) return 1;
        if (arguments.endsWith(".mp4")) return 2;
        return 0;
    }
}
