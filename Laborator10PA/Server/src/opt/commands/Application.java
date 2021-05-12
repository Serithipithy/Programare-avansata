package opt.commands;

import java.util.HashMap;
import java.util.Map;

public class Application {


    private static int connectedUsers = 0;
    private static Map<String,User> users = new HashMap<>();
    private static Application instance = new Application();
    public static boolean stopInitiated = false;
    public static ICommand loginCommand = new LoginCommand();
    public static ICommand registerCommand = new RegisterCommand();
    public static ICommand friendCommand = new FriendCommand();
    public static ICommand sendCommand = new SendCommand();

    public Application() {
    }
    public static int getConnectedUsers() {
        return connectedUsers;
    }
    public static Application getInstance() {
        return instance;
    }
    public static Map<String, User> getUsers() {
        return users;
    }

    public static void addUser(String username){
        Application.users.put(username,new User(username));
    }
    public static void addConnection(){
        ++connectedUsers;
    }
    public static void removeConnection(){
        --connectedUsers;
    }


}
