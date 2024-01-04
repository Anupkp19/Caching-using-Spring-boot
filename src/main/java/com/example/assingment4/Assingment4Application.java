package com.example.assingment4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Assingment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Assingment4Application.class, args);
	}

}
