package main;

import java.util.*;

import bean.Tweet;
import bean.User;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import services.TimelineService;
import services.TotalService;
import servicesImpl.TimeLineServiceImpl;
import servicesImpl.TotalServiceImpl;

public class Main {

    private static final Logger Log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Datas datas = new Datas();
        datas.generateBase();

        TimelineService service = new TimeLineServiceImpl();
        TotalService totalService = new TotalServiceImpl();

        List<User> listUser = datas.getList();

        List<Tweet> timeline = service.getTimeLine(listUser.get(0).getName());

        for(Tweet tweet : timeline){
            System.out.println("Tweet : "+tweet.getUser()+" "+tweet.getBody()+" "+tweet.getDate());
        }
    }

    /**
     * Informe sur l'existence de la cle en base
     * 
     * @param key
     * @param jedis
     * @return
     */
    public static boolean existkey(String key, Jedis jedis) {

        if (jedis.exists(key)) {
            System.out.println("La cle : {" + key + "} est presente en base");
            return true;
        }
        return false;

    }

    /**
     * Return All Keys
     * 
     * @param jedis
     */
    public static void allKeys(Jedis jedis) {
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        ArrayList<String> allKeys = new ArrayList<String>();
        while (it.hasNext()) {
            allKeys.add(it.next());
        }

        System.out.println("Toutes les cles trouvees : " + allKeys.toString());
    }

    /**
     * Obtenir les N dernieres entrees pour une key donnee
     * 
     * @param key
     * @param jedis
     * @param nDernierEntree
     * @return
     */
    public static ArrayList<String> nDernierEntree(String key, Jedis jedis, int nDernierEntree) {

        ArrayList<String> lastEntree = new ArrayList<String>();
        Set<String> set = jedis.smembers(key);

        if ((set.size() > nDernierEntree)) {
            int i = 0;
            Iterator<String> monIterator = set.iterator();
            while (monIterator.hasNext() & i < nDernierEntree) {
                lastEntree.add(monIterator.next());
                i++;
            }
            return lastEntree;
        }
        return lastEntree;
    }
}