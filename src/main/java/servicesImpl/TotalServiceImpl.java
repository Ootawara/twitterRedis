package servicesImpl;

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
import services.TotalService;

import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public class TotalServiceImpl implements TotalService {

    FollowDAO daoFollower = new FollowDAOImpl();
    FollowingDAO daoFollowing = new FollowingDAOImpl();
    TweetDAO daoTweet = new TweetDAOImpl();

    @Override
    public int totalFollowers(String userName) {

        List<Tweet> list = daoTweet.getTweet(userName);

        return list.size();
    }

    @Override
    public int totalFollowings(String userName) {

        List<User> list = daoFollowing.getFollowings(userName);

        return list.size();
    }

    @Override
    public int totalTweet(String userName) {

        List<User> list = daoFollower.getFollowers(userName);

        return list.size();
    }
}
