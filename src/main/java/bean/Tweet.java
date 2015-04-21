package bean;

public class Tweet {

    private int timeId;
    private User User;
    private String body;

    public Tweet(int timeId, User User, String body) {
        this.timeId = timeId;
        this.User = User;
        this.body = body;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "Tweet [timeId=" + timeId + ", User=" + User + ", body=" + body + "]";
    }

}
