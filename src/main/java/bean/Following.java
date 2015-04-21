package bean;

import java.util.ArrayList;

/**
 * L'utilisateur suit les followers (est abonné)
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Following {

    private User User;
    private ArrayList<User> followers;

    public Following(User User, ArrayList<User> followers) {
        this.User = User;
        this.followers = followers;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }
}
