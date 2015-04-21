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
    private ArrayList<User> followers;

    public Followers(User User, ArrayList<User> followers) {
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
