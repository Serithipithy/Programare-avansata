package opt.commands;

import java.util.LinkedList;
import java.util.List;

public class Messages {
    public static List<String> messages = new LinkedList();

    public static List<String> getMessages() {
        return messages;
    }

    public static void setMessages(String text) {
        Messages.messages.add(text);
    }

    public static String myToString() {
        StringBuilder toSend = new StringBuilder(" ");
        for (String message : messages) {
            toSend.append(message);
        }
        return toSend.toString();
    }
}
