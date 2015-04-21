package bean;

import java.util.ArrayList;

/**
 * Les utilisateurs qui suivent (abonnees au) user
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Followers {

    private Username username;
    private ArrayList<Username> following;

    public Followers(Username username, ArrayList<Username> following) {
        this.username = username;
        this.following = following;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public ArrayList<Username> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<Username> following) {
        this.following = following;
    }

    
}
