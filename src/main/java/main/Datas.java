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
import java.util.Date;
import java.util.List;

import utils.ramdom;

public class Datas {

	UserDAO userDao = new UserDAOImpl();
	TweetDAO tweetDao = new TweetDAOImpl();
	FollowDAO followDao = new FollowDAOImpl();
	FollowingDAO followingDao = new FollowingDAOImpl();

	// User
	public User user1 = new User("nameUser1", "ihfljf");
	public User user2 = new User("nameUser2", "sfkf");
	public User user3 = new User("nameUser3", "sf");

	// Tweets
	public Tweet tweet1 = new Tweet(user1.getName(),
			"body of tweet 1 and posted by user 1", (String.valueOf(new Date()
					.getTime() + ramdom.randInt(0, 9999))));
	public Tweet tweet2 = new Tweet(user2.getName(),
			"body of tweet 2 and posted by user 1", (String.valueOf(new Date()
					.getTime() + ramdom.randInt(0, 9999))));
	public Tweet tweet3 = new Tweet(user2.getName(),
			"body of tweet 3 and posted by user 2", (String.valueOf(new Date()
					.getTime() + ramdom.randInt(0, 9999))));
	public Tweet tweet4 = new Tweet(user3.getName(),
			"body of tweet 4 and posted by user 3", (String.valueOf(new Date()
					.getTime() + ramdom.randInt(0, 9999))));

	public List<User> listUsers = new ArrayList<User>();

	public void generateBase() {

		userDao.createUser(user1.getName(), user1.getPassword());
		userDao.createUser(user2.getName(), user2.getPassword());
		userDao.createUser(user3.getName(), user3.getPassword());

		tweetDao.createTweet(tweet1);
		tweetDao.createTweet(tweet2);
		tweetDao.createTweet(tweet3);
		tweetDao.createTweet(tweet4);

		// user 1 followers
		followDao.addFollow(user1.getName(), user2.getName());
		followDao.addFollow(user1.getName(), user3.getName());

		// user 2 following
		followingDao.addFollow(user2.getName(), user1.getName());
		followingDao.addFollow(user2.getName(), user3.getName());
		
	}

	public List<User> getList() {
		listUsers.add(user1);
		listUsers.add(user2);
		listUsers.add(user3);

		return listUsers;
	}
}
