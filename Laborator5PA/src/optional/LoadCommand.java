package optional;

import compulsory.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class LoadCommand extends Command {

    public LoadCommand(String arguments, Catalog catalog) {
        super(arguments, catalog);
    }

    public void executeCommand() throws IOException, InvalidCatalogData {
        try {
            String data = new String(Files.readAllBytes(Paths.get(arguments)));
            StringTokenizer tokenizer = new StringTokenizer(data, "\r\n");
            // extracts the name and the path from the folder
            String buffer = tokenizer.nextToken();
            catalog.setName(buffer);
            buffer = tokenizer.nextToken();
            catalog.setPath(buffer);

            while (tokenizer.hasMoreTokens()) {
                buffer = tokenizer.nextToken();
                if (buffer.startsWith("Movie:")) { //if it is a movie, it will extract all the info and will add to the item list

                    String id = tokenizer.nextToken();
                    String name = tokenizer.nextToken();
                    String location = tokenizer.nextToken();
                    int duration = stringToInt(tokenizer.nextToken());
                    int year = stringToInt(tokenizer.nextToken());
                    String genre = tokenizer.nextToken();

                    catalog.getItems().add(new Movie(id, name, location, duration, year, genre));

                } else if (buffer.startsWith("Book:")) { //if it is a book, it will extract all the info and will add to the item list
                    String id = tokenizer.nextToken();
                    String name = tokenizer.nextToken();
                    String location = tokenizer.nextToken();
                    String author = tokenizer.nextToken();
                    int pageNumber = stringToInt(tokenizer.nextToken());

                    catalog.getItems().add(new Book(id, name, location, author, pageNumber));
                }

            }
        } catch (FileNotFoundException | InvalidCatalogData | InvalidItemData e) {
            e.printStackTrace();
        }
    }

    private int stringToInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char digit = (char) (str.charAt(i) - '0');
            result += (digit * Math.pow(10, (str.length() - i - 1)));

        }
        return result;
    }
}

