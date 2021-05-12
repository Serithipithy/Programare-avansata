package opt.commands;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> friends = new ArrayList();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List getFriends() {
        return friends;
    }

    public void addFriends(User username) {
        this.friends.add(username);
    }
}
