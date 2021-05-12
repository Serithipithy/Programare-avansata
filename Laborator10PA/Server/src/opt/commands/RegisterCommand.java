package opt.commands;

public class RegisterCommand implements ICommand {
    public RegisterCommand(){
    }

    @Override
    public boolean execute(String username, String text) {
        if(!Application.getUsers().containsKey(username)){
            Application.addUser(username);
            return true;
        }
        return false;
    }

}
