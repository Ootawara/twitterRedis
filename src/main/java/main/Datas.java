package main;

import bean.Tweet;
import bean.User;

import java.util.ArrayList;

public class Datas {

    // User
    public static User user1 = new User("nameUser1","ihfljf");
    public static User user2 = new User("nameUser2","sfkf");
    public static User user3 = new User("nameUser3","sf");

    // Tweets
    public static Tweet tweet1 = new Tweet(1, user1, "body of tweet 1, posted by user 1");
    public static Tweet tweet2 = new Tweet(2, user1, "body of tweet 2, posted by user 1");
    public static Tweet tweet3 = new Tweet(3, user2, "body of tweet 3, posted by user 2");
    public static Tweet tweet4 = new Tweet(4, user3, "body of tweet 4, posted by user 3");

    // Historique (des tweets posté par des utilisateurs)
    // public static Historique histo = new Historique();

    public static ArrayList<User> listFollowers = new ArrayList<User>();
   
    
//    
//    public static Followers followers = new Followers(user1, );
//
//    public static Following follow = new Followers(user1, following);

}
