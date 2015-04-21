package dao;

import java.util.List;

import bean.Tweet;
import bean.Username;

public interface  TweetDAO {
	
    public List<Tweet> getAllTweet();    
    public List<Tweet> getTweetByUser(Username user);
    public Tweet getTweet(int tweetId);
    public void createTweet(Tweet tweet);
    public void deleteTweet(Tweet tweet);

	
}
