package bean;

import java.util.ArrayList;

/**
 * L'utilisateur suit les followers (est abonné)
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Following {

    private String userName;
    private ArrayList<String> following;

    public Following(String User, ArrayList<String> following) {
        this.userName = User;
        this.following = following;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String User) {
        this.userName = User;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowers(ArrayList<String> following) {
        this.following = following;
    }
}
