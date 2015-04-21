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
    private ArrayList<User> following;

    public Following(User User, ArrayList<User> following) {
        this.User = User;
        this.following = following;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowers(ArrayList<User> following) {
        this.following = following;
    }
}
