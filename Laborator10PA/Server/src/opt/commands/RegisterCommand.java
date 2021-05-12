package opt.commands;

public class RegisterCommand implements ICommand {
    public RegisterCommand(){
    }

    @Override
    public boolean execute(String username, String text) {
        if(validateText(text)){
            Application.addUser(username);
            return true;
        }
        return false;
    }

    @Override
    public boolean validateText(String text) {
        if(text.equals("") || text.isEmpty()) return true;
        return false;
    }
}
