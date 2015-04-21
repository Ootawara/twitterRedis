package dao;

import bean.Tweet;
import bean.User;

import java.util.List;

public interface TweetDAO {

    public List<Tweet> getTweet(String userName);
    public void createTweet(Tweet tweet);
    public void deleteTweet(Tweet tweet);

}
