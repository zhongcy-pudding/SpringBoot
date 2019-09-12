package com.zhongcy.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhongcy.springboot.Dao.IUserResository;
import com.zhongcy.springboot.Mapper.IUserMapper;
import com.zhongcy.springboot.entity.JpaUser;
import com.zhongcy.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuickApplicationTests {
	@Autowired
	IUserMapper userMapper;
	@Autowired
	IUserResository userResository;
	@Autowired
	RedisTemplate<String,String> redisTemplate;

	// 测试mybatis
	@Test
	public void testMybatis() {

		List<User> users = userMapper.queryUserList();
		users.stream().forEach(s-> System.out.println(s));
	}
	// 测试jpa
	@Test
	public void testJpa() {

		List<JpaUser> users = userResository.findAll();
		users.stream().forEach(s-> System.out.println(s.getName()));
	}

	// 测试redis
	@Test
	public void testRedis() throws JsonProcessingException {
		String redisJson = redisTemplate.boundValueOps("user.findAll").get();
		if(redisJson==null){
			List<JpaUser> users = userResository.findAll();
			ObjectMapper mapper=new ObjectMapper();
			redisJson = mapper.writeValueAsString(users);
			redisTemplate.boundValueOps("user.findAll").set(redisJson);
			System.out.println("数据库查询");
		}else{
			System.out.println("redis查询");
		}

		System.out.println(redisJson);
	}

}
