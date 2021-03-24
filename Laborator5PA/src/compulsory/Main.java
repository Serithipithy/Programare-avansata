package compulsory;

import optional.InvalidCommandData;
import optional.Shell;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException | URISyntaxException | InvalidCatalogData | InvalidItemData | InvalidCommandData a) {
            System.err.println(a);
        }
    }

    private void testCreateSave() throws IOException, URISyntaxException, InvalidCatalogData, InvalidItemData, InvalidCommandData {
        Catalog catalog =
                new Catalog("My Books", "D:\\lab\\media\\catalog.ser");
        var movie = new Movie("bestMovie", "Interstellar", "https://www.instagram.com/p/CMQBORej_LR/", 123, 2016, "SF");
        var book = new Book("bestBook", "The minds of Billy Milligan", "D:\\lab\\bestBook.txt", "Daniel Keyes", 245);
        catalog.add(movie);
        catalog.add(book);
//        catalog.list();
//        catalog.play(1);
//        catalog.play(0);
//        catalog.save();

//        Catalog catalog2 = new Catalog();
//        catalog2.load("D:\\lab\\catalogNou.txt");
//        catalog2.list();


        Shell newShell = new Shell();
        newShell.readFromCommandLine();
        newShell.executeCommand(catalog); //add englishBook Taboo-and-Issues author 100 D:\lab\Taboos_and_Issues.pdf
        newShell.readFromCommandLine();
        newShell.executeCommand(catalog); //load D:\lab\catalogNou.txt
        newShell.readFromCommandLine();
        newShell.executeCommand(catalog); //play englishBook
        newShell.readFromCommandLine();
        newShell.executeCommand(catalog); //save
        newShell.readFromCommandLine();
        newShell.executeCommand(catalog); //list

    }

}

