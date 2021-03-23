package optional;

import compulsory.Catalog;
import compulsory.InvalidCatalogData;
import compulsory.InvalidItemData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class Shell {
    private String command;
    private String arguments;

    public Shell() {
    }

    public void readFromCommandLine() throws IOException { // reads commands from the keyboard and their arguments
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Command: ");
        String text = reader.readLine();
        String[] input;
        input = text.split(" ", 2);
        command = input[0];
        if (input.length > 1) arguments = input[1];
        else arguments = null;
    }

    public void executeCommand(Catalog catalog)
            throws InvalidCommandData, InvalidItemData, IOException, InvalidCatalogData, URISyntaxException { // executes the command introduced
        switch (command) {
            case "add" -> new AddCommand(arguments, catalog).executeCommand();
            case "list" -> new ListCommand(arguments, catalog).executeCommand();
            case "save" -> new SaveCommand(arguments, catalog).executeCommand();
            case "load" -> new LoadCommand(arguments, catalog).executeCommand();
            case "play" -> new PlayCommand(arguments, catalog).executeCommand();
            default -> throw new InvalidCommandData();
        }
    }

    public String getCommand() {
        return command;
    }

    public String getArguments() {
        return arguments;
    }
}
