package daoImpl;

/**
 * @author Thomas
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.*;

public class ClientRedis {
	
	Jedis client;
	
	public ClientRedis(){
		client = new Jedis("localhost");
		
		System.out.println("Server is running : " + client.ping());
	}
	
	public void jedisSet(String key, String value){
		client.set(key, value);
	}

	public String jedisGet(String key){
		return client.get(key);
	}
	
	public void list(String key, String val, String val1, String val2){
		client.lpush(key, val);
		client.lpush(key, val1);
		client.lpush(key, val2);
	}
	
	public List<String> getElements(String key, long a, long b){
		return (List<String>) client.lrange(key, a, b);
	}
	
	public HashSet<String> getKeys(String s){
		return (HashSet<String>) client.keys(s);
	}

	public Jedis getClient(){ return this.client; }

	public void zRem(String value){
		client.zrem(value);
	}

	public void delete(String value){
		client.del(value);
	}

	public void setHM(String key, Map properties){
		client.hmset(key, properties);
	}
}