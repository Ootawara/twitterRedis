package daoImpl;

import bean.User;
import dao.FollowingDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tamiand on 21/04/2015.
 */
public class FollowingDAOImpl implements FollowingDAO {

    ClientRedis client = new ClientRedis();

    static final String keyUsers = "users";
    static final String key = "followings:";
    static final String loginField = "username";
    static final String passField = "password";

    @Override
    public void addFollow(String userName, String followName) {

        List<String> uids = client.getClient().hmget(keyUsers, userName);

        String UID = uids.get(0);

        Map<String, String> followProperties = new HashMap<String, String>();
        followProperties.put(userName, followName);

        client.setHM(key+UID, followProperties);
    }

    @Override
    public List<User> getFollowings(String userName) {

        List<String> uids = client.getClient().hmget(keyUsers, userName);

        String UID = uids.get(0);

        List<String> followingsName = client.getClient().hmget(key+UID, userName);

        List<User> listToReturn = new ArrayList<User>();

        for(String name : followingsName){
            List<String> followingUID = client.getClient().hmget(keyUsers, name);
            String UIDfollow = followingUID.get(0);
            List<String> userProperties =  client.getClient().hmget(key+UIDfollow, loginField, passField);
            listToReturn.add(new User(userProperties.get(0), userProperties.get(1)));
        }

        return listToReturn;
    }
}
