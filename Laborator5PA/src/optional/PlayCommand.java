package optional;

import compulsory.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PlayCommand extends Command {

    public PlayCommand(String arguments, Catalog catalog) {
        super(arguments, catalog);
    }

    public void executeCommand() throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        if (catalog.findById(arguments).getLocation().startsWith("D:")) { // if it is a local file will open as a normal one
            File file = new File(catalog.findById(arguments).getLocation());
            desktop.open(file);
        } else if (catalog.findById(arguments).getLocation().startsWith("https")) { // if it starts with https the it's a link and will open the ulr in the browser
            URI uri = new URI(catalog.findById(arguments).getLocation());
            desktop.browse(uri);
        }
    }
}
