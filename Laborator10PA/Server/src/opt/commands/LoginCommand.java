package opt.commands;

public class LoginCommand implements ICommand {
    public LoginCommand() {
    }

    @Override
    public boolean execute(String username, String text) {
        if (Application.getUsers().containsKey(username)) {
            Application.addConnection();
            return true;
        } else return false;
    }

}
