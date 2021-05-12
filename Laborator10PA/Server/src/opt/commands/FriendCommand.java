package opt.commands;

public class FriendCommand implements ICommand {
    @Override
    public boolean execute(String username, String text) {
        if (!text.isEmpty()) {
            if (text.contains(" ")) {
                String[] friends = text.split(" ");
                for (String friend : friends) {
                    if (Application.getUsers().containsKey(friend)) {
                        if (!Application.getUsers().get(username).getFriends().contains(Application.getUsers().get(friend)))
                            // see if they are already friends
                        {
                            Application.getUsers().get(username).addFriends(Application.getUsers().get(friend));
                            Application.getUsers().get(friend).addFriends(Application.getUsers().get(username));
                        }
                    }
                }
            } else {
                if (Application.getUsers().containsKey(text)) {
                    if (!Application.getUsers().get(username).getFriends().contains(Application.getUsers().get(text)))
                        // see if they are already friends
                    {
                        Application.getUsers().get(username).addFriends(Application.getUsers().get(text));
                        Application.getUsers().get(text).addFriends(Application.getUsers().get(username));
                    }
                }
            }
            return true;
        }
        return false;
    }

}
