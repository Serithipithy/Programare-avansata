package opt.commands;

public class SendCommand implements ICommand {
    public SendCommand() {
    }

    @Override
    public boolean execute(String username, String text) {
        if (!text.equals("")) {
            Messages.getMessages().add(username + ": " + text + "\n");
            return true;
        }
        return false;
    }
}
