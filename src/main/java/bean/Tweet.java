package bean;

import java.util.Date;

public class Tweet {

    private String userName;
    private String body;
    private String dateCreated;

    public Tweet(String User, String body, String date) {
        this.userName = User;
        this.body = body;
        dateCreated = date;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String User) {
        this.userName = User;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate(){
        return dateCreated;
    }

    public void setDate(String date){
        this.dateCreated = date;
    }

    public String toString() {
        return "User=" + userName + ", body=" + body + "]";
    }

}
