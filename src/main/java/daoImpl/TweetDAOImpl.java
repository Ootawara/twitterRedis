package daoImpl;

import bean.Tweet;
import bean.User;
import dao.TweetDAO;

import java.util.*;

public class TweetDAOImpl implements TweetDAO{

    ClientRedis client = new ClientRedis();

    static final String keyTweets = "tweets";
    static final String key = "tweet:";
    static final String idField = "id";
    static final String userField = "username";
    static final String textField = "text";
    static final String dateField = "created_at";

    public List<Tweet> getTweet(String userName) {

        List<String> uids = client.getClient().hmget(keyTweets, userName);

        List<Tweet> tweetsToReturn = new ArrayList<Tweet>();

        for(String uid : uids){
            List<String> tweetProperties = client.getClient().hmget(key+uid, idField, userField, textField, dateField);
            Tweet toAdd = new Tweet(tweetProperties.get(0), tweetProperties.get(1));
            toAdd.setDate(tweetProperties.get(3));
            tweetsToReturn.add(toAdd);
        }

        return tweetsToReturn;
    }

    public void createTweet(Tweet tweet) {

        String UID = String.valueOf(new Date().getTime());

        Map<String, String> tweetUID = new HashMap<String, String>();
        tweetUID.put(tweet.getUser(), UID);

        client.setHM(keyTweets, tweetUID);

        Map<String, String> tweetProperties = new HashMap<String, String>();
        tweetProperties.put(userField, tweet.getUser());
        tweetProperties.put(textField, tweet.getBody());
        tweetProperties.put(dateField, tweet.getDate());

        client.setHM(key+UID, tweetProperties);
    }

    public void deleteTweet(Tweet tweet) {

        List<String> uids = client.getClient().hmget(keyTweets, tweet.getUser());
        String uidToDelete = uids.get(0);
        client.zRem(tweet.getUser());

        client.delete(key+uidToDelete);
    }
}
