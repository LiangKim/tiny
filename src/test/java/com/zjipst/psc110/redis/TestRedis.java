package com.zjipst.psc110.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {

	@Test
	public void connect(){
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		jedis.set("mykey", "king-kong");
		System.out.println("mykey:"+jedis.get("mykey"));
		jedis.close();
	}
}
