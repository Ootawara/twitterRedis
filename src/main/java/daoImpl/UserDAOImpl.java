package daoImpl;

import bean.User;
import dao.UserDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tamiand on 21/04/2015.
 */
public class UserDAOImpl implements UserDAO {

    ClientRedis client = new ClientRedis();

    static final String keyUsers = "users";
    static final String key = "user:";
    static final String loginField = "name";
    static final String passField = "password";


    public void createUser(String login, String password) {

        String UID = String.valueOf(new Date().getTime());

        Map<String,String> userUID = new HashMap<String, String>();
        userUID.put(login, UID);

        client.getClient().hmset(keyUsers, userUID);

        Map<String,String> userProperties = new HashMap<String,String>();
        userProperties.put(loginField, login);
        userProperties.put(passField, password);

        client.setHM(key + UID, userProperties);
    }

    public void deleteUser(String login) {

        List<String> uids = client.getClient().hmget(keyUsers, login);
        String uidToDelete = uids.get(0);
        client.zRem(login);

        client.delete(key+uidToDelete);
    }

    public User getUser(String login) {

        List<String> uids = client.getClient().hmget(keyUsers, login);
        String uidToGet = uids.get(0);
        List<String> userProperties =  client.getClient().hmget(key+uidToGet, loginField, passField);
        User toReturn = new User(userProperties.get(0), userProperties.get(1));
        return toReturn;
    }
}
