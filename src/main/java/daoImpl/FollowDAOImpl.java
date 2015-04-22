package daoImpl;

import bean.User;
import dao.FollowDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tamiand on 21/04/2015.
 */
public class FollowDAOImpl implements FollowDAO {

    ClientRedis client = new ClientRedis();

    static final String keyUsers = "users";
    static final String key = "followers:";
    static final String loginField = "username";
    static final String passField = "password";

    public void addFollow(String userName, String followName) {

        List<String> uids = client.getClient().hmget(keyUsers, userName);

        String UID = uids.get(0);

        Map<String, String> followProperties = new HashMap<String, String>();
        followProperties.put(userName, followName);

        client.setHM(key+UID, followProperties);
    }

    public List<User> getFollowers(String userName) {

        List<String> uids = client.getClient().hmget(keyUsers, userName);

        String UID = uids.get(0);

        List<String> followersName = client.getClient().hmget(key+UID, userName);

        List<User> listToReturn = new ArrayList<User>();

        for(String name : followersName){
            List<String> followerUID = client.getClient().hmget(keyUsers, name);
            String UIDfollow = followerUID.get(0);
            List<String> userProperties =  client.getClient().hmget(key+UIDfollow, loginField, passField);
            listToReturn.add(new User(userProperties.get(0), userProperties.get(1)));
        }

        return listToReturn;
    }
}
