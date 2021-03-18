package compulsory;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.util.StringTokenizer;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    // constructor
    public Catalog() {
    }

    public Catalog(String name, String path) throws InvalidCatalogData {
        this.setName(name);
        this.setPath(path);
    }
    //setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidCatalogData {
        if (name == null) throw new InvalidCatalogData(" empty name");
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws InvalidCatalogData {
        if (!path.contains("https") && !path.contains("D:")) throw new InvalidCatalogData(" wrong path format");
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    // commands methods

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void list() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("Item " + (i + 1) + " : '" +
                    this.items.get(i).getName() + "' has the location: " +
                    this.items.get(i).getLocation() + ", " +
                    this.items.get(i).toString());
        }
    }

    public void play(int index) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        if (this.items.get(index).getLocation().startsWith("D:")) { // if it is a local file will open as a normal one
            File file = new File(this.items.get(index).getLocation());
            desktop.open(file);
        } else if (this.items.get(index).getLocation().startsWith("https")) { // if it starts with https the it's a link and will open the ulr in the browser
            URI uri = new URI(this.items.get(index).getLocation());
            desktop.browse(uri);
        }
    }

    public void save() throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(this.getPath()))) {
            oos.writeObject(this);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void load(String path) throws IOException {
        try {
            String data = new String(Files.readAllBytes(Paths.get(path)));
            StringTokenizer tokenizer = new StringTokenizer(data, "\r\n");
            // extracts the name and the path from the folder
            String buffer = tokenizer.nextToken();
            this.setName(buffer);
            buffer = tokenizer.nextToken();
            this.setPath(buffer);

            while (tokenizer.hasMoreTokens()) {
                buffer = tokenizer.nextToken();
                if (buffer.startsWith("Movie:")) { //if it is a movie, it will extract all the info and will add to the item list

                    String id = tokenizer.nextToken();
                    String name = tokenizer.nextToken();
                    String location = tokenizer.nextToken();
                    int duration = StringToInt(tokenizer.nextToken());
                    int year = StringToInt(tokenizer.nextToken());
                    String genre = tokenizer.nextToken();

                    this.getItems().add(new Movie(id, name, location, duration, year, genre));

                } else if (buffer.startsWith("Book:")) { //if it is a book, it will extract all the info and will add to the item list
                    String id = tokenizer.nextToken();
                    String name = tokenizer.nextToken();
                    String location = tokenizer.nextToken();
                    String author = tokenizer.nextToken();
                    int pageNumber = StringToInt(tokenizer.nextToken());

                    this.getItems().add(new Book(id, name, location, author, pageNumber));
                }

            }

        } catch (FileNotFoundException | InvalidCatalogData | InvalidItemData e) {
            e.printStackTrace();
        }

    }

    private int StringToInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char digit = (char) (str.charAt(i) - '0');
            result += (digit * Math.pow(10, (str.length() - i - 1)));

        }
        return result;
    }
}
