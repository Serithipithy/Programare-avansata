package opt.commands;

public class FriendCommand extends Application implements ICommand{
    @Override
    public boolean execute(String username, String text) {
        if(!text.isEmpty()){
            if(text.contains(" ")) {
                String[] friends = text.split(" ");
                for (String friend : friends) {
                    if (getUsers().containsKey(friend)) {
                        if (!getUsers().get(username).getFriends().contains(getUsers().get(friend))) // see if they are already friends
                        {
                            getUsers().get(username).addFriends(getUsers().get(friend));
                            getUsers().get(friend).addFriends(getUsers().get(username));
                        }
                    }
                }
            }
            else{
                if (getUsers().containsKey(text)) {
                    if (!getUsers().get(username).getFriends().contains(getUsers().get(text))) // see if they are already friends
                    {
                        getUsers().get(username).addFriends(getUsers().get(text));
                        getUsers().get(text).addFriends(getUsers().get(username));
                    }
                }
            }
            return true;
        }
        return false;
    }

}
