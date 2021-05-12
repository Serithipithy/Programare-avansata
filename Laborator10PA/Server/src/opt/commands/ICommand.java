package opt.commands;

public interface ICommand {
    boolean execute(String username,String text);
    boolean validateText(String text);
}
