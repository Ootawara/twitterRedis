package bean;

public class Historique {

    private Username username;
    private Tweet tweet;

    public Historique(Username username, Tweet tweet) {
        this.username = username;
        this.tweet = tweet;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

}
