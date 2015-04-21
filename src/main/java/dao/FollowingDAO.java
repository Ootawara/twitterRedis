package dao;

import bean.User;

import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public interface FollowingDAO {

    public void addFollow(String userName, String followName);
    public List<User> getFollowings(String userName);
}
