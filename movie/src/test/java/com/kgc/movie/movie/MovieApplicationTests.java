package com.kgc.movie.movie;

import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.service.Membership_levelService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MovieApplicationTests {
@Resource
	Membership_levelService membership_levelService;
	@Test
	void contextLoads() {
		List<Membership_level> select = membership_levelService.select("黄金会员");
		for (Membership_level membership_level : select) {
			System.out.println(membership_level.toString());
		}
	}

}
