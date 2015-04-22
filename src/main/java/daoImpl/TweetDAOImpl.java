package daoImpl;

import bean.Tweet;
import dao.TweetDAO;

import java.util.*;

import dao.UserDAO;
import utils.ramdom;

public class TweetDAOImpl implements TweetDAO{

    ClientRedis client = new ClientRedis();

    static final String keyTweets = "tweets:";
    static final String key = "tweet:";
    static final String idField = "id";
    static final String userField = "username";
    static final String textField = "text";
    static final String dateField = "created_at";

    UserDAO daoUser = new UserDAOImpl();

    public List<Tweet> getTweet(String userName) {

        String uids = client.getClient().get(keyTweets+userName);

        String[] parts = uids.split(",");
        List<String> UID = new ArrayList<String>();
        for(int i=0;  i<parts.length; i++){
            if (i==0){
                String s = parts[i].substring(0);
            }
            else if(i==parts.length-1){
                String s = parts[i].substring(parts[i].length()-1);
            }
            UID.add(parts[i]);
        }

        List<Tweet> tweetsToReturn = new ArrayList<Tweet>();

        for(String uid : UID){
            List<String> tweetProperties = client.getClient().hmget(key+uid, idField, userField, textField, dateField);
            Tweet toAdd = new Tweet(tweetProperties.get(1), tweetProperties.get(2), tweetProperties.get(3));
            tweetsToReturn.add(toAdd);
        }

        return tweetsToReturn;
    }

    public void createTweet(Tweet tweet) {

        String UID = String.valueOf(new Date().getTime() + ramdom.randInt(0, 9999));

        String UIDUser = daoUser.getUID(tweet.getUser());

        client.getClient().lpush(keyTweets+UIDUser, UID);

        Map<String, String> tweetProperties = new HashMap<String, String>();
        tweetProperties.put(userField, tweet.getUser());
        tweetProperties.put(textField, tweet.getBody());
        tweetProperties.put(dateField, tweet.getDate());

        client.setHM(key+UID, tweetProperties);
    }

    /*public void deleteTweet(Tweet tweet) {

        List<String> uids = client.getClient().l(keyTweets, tweet.getUser());
        String uidToDelete = uids.get(0);
        client.zRem(tweet.getUser());

        client.delete(key+uidToDelete);
    }*/
}
