package bean;

public class Tweet {

    private int timeId;
    private Username username;
    private String body;

    public Tweet(int timeId, Username username, String body) {
        this.timeId = timeId;
        this.username = username;
        this.body = body;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "Tweet [timeId=" + timeId + ", username=" + username + ", body=" + body + "]";
    }

}
