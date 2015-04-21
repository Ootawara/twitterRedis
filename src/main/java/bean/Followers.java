package bean;

import java.util.ArrayList;

/**
 * Les utilisateurs qui suivent (abonnees au) user
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Followers {

    private String userName;
    private ArrayList<String> followers;

    public Followers(String userName, ArrayList<String> followers) {
        this.userName = userName;
        this.followers = followers;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String User) {
        this.userName = User;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    
}
