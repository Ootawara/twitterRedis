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
import services.TotauxService;

import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public class TotalServiceImpl implements TotauxService {

    FollowDAO daoFollower = new FollowDAOImpl();
    FollowingDAO daoFollowing = new FollowingDAOImpl();
    TweetDAO daoTweet = new TweetDAOImpl();

    public int totalTweet(String userName) {

        List<Tweet> list = daoTweet.getTweet(userName);

        return list.size();
    }

    public int totalFollowings(String userName) {

        List<User> list = daoFollowing.getFollowings(userName);

        return list.size();
    }

    public int totalFollowers(String userName) {

        List<User> list = daoFollower.getFollowers(userName);

        return list.size();
    }
}
