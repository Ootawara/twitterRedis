package dao;

import bean.User;

import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public interface FollowDAO {

    public void addFollow(String userName, String followName);
    public List<User> getFollowers(String userName);
}
