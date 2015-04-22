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

	private static Logger Log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		int i = 0;
		System.out.println("Génération de la base...");
		Datas datas = new Datas();
		datas.generateBase();
		System.out.println("Génération de la base OK");

		TimelineService service = new TimeLineServiceImpl();
		TotauxService totauxService = new TotalServiceImpl();

		List<User> listUser = datas.getList();

		for (User user : listUser) {
			
			List<Tweet> timeline = service.getTimeLine(listUser.get(i)
					.getName());

			for (Tweet tweet : timeline) {
				System.out.println("User = " + listUser.get(i)
						.getName() + ", Tweet n°" + i + " : User = "
						+ tweet.getUser() + " Body = " + tweet.getBody()
						+ " Date = " + tweet.getDate());
			}
			i++;

		}
	}

}