package servicesImpl;

import bean.Tweet;
import bean.User;
import dao.FollowDAO;
import dao.TweetDAO;
import dao.UserDAO;
import daoImpl.FollowDAOImpl;
import daoImpl.TweetDAOImpl;
import daoImpl.UserDAOImpl;
import services.TimelineService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public class TimeLineServiceImpl implements TimelineService {

    UserDAO daoUser = new UserDAOImpl();
    FollowDAO daoFollower = new FollowDAOImpl();
    TweetDAO daoTweet = new TweetDAOImpl();

    public List<Tweet> getTimeLine(String userName) {

        List<Tweet> tweetUser = daoTweet.getTweet(userName);
        List<User> followers = daoFollower.getFollowers(userName);
        List<Tweet> tweetFollowers = new ArrayList<Tweet>();

        for(User follower : followers){
            tweetFollowers.addAll(daoTweet.getTweet(follower.getName()));
        }

        List<Tweet> timeLine = new ArrayList<Tweet>();
        timeLine.addAll(tweetUser);
        timeLine.addAll(tweetFollowers);
        Collections.sort(timeLine, new Comparator<Tweet>() {
        	
            public int compare(Tweet  tweet1, Tweet  tweet2)
            {
                return  tweet1.getDate().compareTo(tweet2.getDate());
            }
        });

        return timeLine;
    }
}
