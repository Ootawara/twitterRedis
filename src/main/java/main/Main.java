package main;

import java.util.*;

import bean.Tweet;
import bean.User;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import services.TimelineService;
import services.TotauxService;
import servicesImpl.TimeLineServiceImpl;
import servicesImpl.TotalServiceImpl;

public class Main {

    private static final Logger Log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Datas datas = new Datas();
        datas.generateBase();

        TimelineService service = new TimeLineServiceImpl();
        TotauxService totauxService = new TotalServiceImpl();

        List<User> listUser = datas.getList();

        List<Tweet> timeline = service.getTimeLine(listUser.get(0).getName());

        for(Tweet tweet : timeline){
            System.out.println("Tweet : "+tweet.getUser()+" "+tweet.getBody()+" "+tweet.getDate());
        }
    }
}