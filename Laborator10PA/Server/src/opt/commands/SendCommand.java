package opt.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SendCommand implements ICommand{
    public SendCommand() {
    }


    @Override
    public boolean execute(String username, String text) {
        if(validateText(text)){
            Messages.getMessages().add(username + ": " + text + "\n");
            return true;
        }
        return false;
    }



    @Override
    public boolean validateText(String text) {
        return true;
    }
}
