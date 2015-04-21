package bean;

public class Historique {

    private User User;
    private Tweet tweet;

    public Historique(User User, Tweet tweet) {
        this.User = User;
        this.tweet = tweet;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

}
