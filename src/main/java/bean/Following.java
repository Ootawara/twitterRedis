package bean;

import java.util.ArrayList;

/**
 * L'utilisateur suit les followers (est abonné)
 * 
 * @author emmanuel_plaisance
 * 
 */
public class Following {

    private Username username;
    private ArrayList<Username> followers;

    public Following(Username username, ArrayList<Username> followers) {
        this.username = username;
        this.followers = followers;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public ArrayList<Username> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Username> followers) {
        this.followers = followers;
    }
}
