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
import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public class TimeLineServiceImpl implements TimelineService {

    UserDAO daoUser = new UserDAOImpl();
    FollowDAO daoFollower = new FollowDAOImpl();
    TweetDAO daoTweet = new TweetDAOImpl();

    @Override
    public List<Tweet> getTimeLine(String userName) {

        List<Tweet> tweetUser = daoTweet.getTweet(userName);
        List<User> followers = daoFollower.getFollowers(userName);
        List<Tweet> tweetFollowers = new ArrayList<Tweet>();

        for(User follower : followers){

        }

        return null;
    }
}
