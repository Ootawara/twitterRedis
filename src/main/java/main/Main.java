package main;

import java.util.*;

import bean.User;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

public class Main {

    private static final Logger Log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // Connection au serveur Redis
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connexion au serveur REDIS : " + jedis.ping());

        // Nom des keys
        String key1 = "legume";
        String key2 = "lettre";

        // Ajouter une nouvelle key
        jedis.set("key", "value");
        jedis.set("lang", "C");
        jedis.set("lang", "Java");
        jedis.set("lang", "Php");

        // Retourne la valeur de la key
        System.out.println(jedis.get("lang"));

        jedis.sadd(key1, "tomate", "haricot");
        jedis.sadd(key2, "a", "b", "c", "d", "e", "f");
        jedis.sadd(key2, "g", "h");

        System.out.println(key1 + " : " + jedis.smembers(key1));
        System.out.println(key2 + " : " + jedis.smembers(key2));

        System.out.println("Les 4 dernieres entrees pour " + key2 + " sont : " + nDernierEntree(key2, jedis, 4));

        // System.out.println("Clean base : "+jedis.flushDB());

        System.out.println("Existence de cles : " + jedis.exists("lettre"));
        // regarder dans les projets SONAR
        // log.
        // log.info("", jedis.exists("lettre"));
        // log.info("Existence de cles : {} ", key1);

        allKeys(jedis);
        existkey(key2, jedis);

        User user = new User("lol","loul");
        Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("name", user.getName());
        userProperties.put("password", user.getPassword());

        jedis.hmset("user:" + user.getName(), userProperties);

        System.out.println(jedis.hmget("user:" + user.getName(), "name","password"));
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