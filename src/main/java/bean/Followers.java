package bean;

import java.util.ArrayList;

/**
 * Les utilisateurs qui suivent (abonnees au) user
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Followers {

    private User User;
    private ArrayList<User> following;

    public Followers(User User, ArrayList<User> following) {
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

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    
}
