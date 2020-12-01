package com.kgc.movie.movie;

import com.kgc.movie.movie.pojo.Movie_ticket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class MovieApplicationTests {

	@Resource
	RedisTemplate<Object, Movie_ticket> redisTemplate;
	@Test
	void contextLoads() {
	}

}
