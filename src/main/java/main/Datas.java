package main;

import bean.Tweet;
import bean.User;
import dao.FollowDAO;
import dao.FollowingDAO;
import dao.TweetDAO;
import dao.UserDAO;
import daoImpl.FollowDAOImpl;
import daoImpl.FollowingDAOImpl;
import daoImpl.TweetDAOImpl;
import daoImpl.UserDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    UserDAO userDao = new UserDAOImpl();
    TweetDAO tweetDao = new TweetDAOImpl();
    FollowDAO followDao = new FollowDAOImpl();
    FollowingDAO followingDao = new FollowingDAOImpl();

    // User
    public static User user1 = new User("nameUser1","ihfljf");
    public static User user2 = new User("nameUser2","sfkf");
    public static User user3 = new User("nameUser3","sf");

    // Tweets
    public static Tweet tweet1 = new Tweet(user1.getName(), "body of tweet 1, posted by user 1");
    public static Tweet tweet2 = new Tweet(user1.getName(), "body of tweet 2, posted by user 1");
    public static Tweet tweet3 = new Tweet(user2.getName(), "body of tweet 3, posted by user 2");
    public static Tweet tweet4 = new Tweet(user3.getName(), "body of tweet 4, posted by user 3");

    public List<User> listUsers = new ArrayList<User>();

    public void generateBase(){

        userDao.createUser(user1.getName(), user1.getPassword());
        userDao.createUser(user2.getName(), user2.getPassword());
        userDao.createUser(user3.getName(), user3.getPassword());

        tweetDao.createTweet(tweet1);tweetDao.createTweet(tweet2);
        tweetDao.createTweet(tweet3);tweetDao.createTweet(tweet4);

        followDao.addFollow(user1.getName(), user2.getName());
        followDao.addFollow(user1.getName(), user3.getName());

        followingDao.addFollow(user2.getName(), user1.getName());
        followingDao.addFollow(user2.getName(), user3.getName());
    }

    public List<User> getList(){
        listUsers.add(user1);listUsers.add(user2);
        listUsers.add(user3);

        return listUsers;
    }
}
