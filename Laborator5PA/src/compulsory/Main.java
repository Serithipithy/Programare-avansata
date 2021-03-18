package compulsory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException | URISyntaxException | InvalidCatalogData | InvalidItemData a) {
            System.err.println(a);
        }
    }

    private void testCreateSave() throws IOException, URISyntaxException, InvalidCatalogData, InvalidItemData {
        Catalog catalog =
                new Catalog("My Books", "D:\\lab\\media\\catalog.txt");
        var movie = new Movie("bestMovie", "Interstellar", "https://www.instagram.com/p/CMQBORej_LR/", 123, 2016, "SF");
        var book = new Book("bestBook", "The minds of Billy Milligan", "D:\\lab\\bestBook.txt", "Daniel Keyes", 245);
        catalog.add(movie);
        catalog.add(book);
        catalog.list();
        catalog.play(1);
        catalog.play(0);
        catalog.save();

        
        Catalog catalog2 = new Catalog();
        catalog2.load("D:\\lab\\catalogNou.txt");
        catalog2.list();

    }

}

