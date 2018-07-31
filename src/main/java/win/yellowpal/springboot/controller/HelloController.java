package win.yellowpal.springboot.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import win.yellowpal.springboot.conf.TestProperties;
import win.yellowpal.springboot.dao.TestMapper;
import win.yellowpal.springboot.dao.UserRepository;
import win.yellowpal.springboot.domain.Test;
import win.yellowpal.springboot.domain.User;

@RestController
public class HelloController {
	
	@Autowired
	private TestProperties testProperties;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private TestMapper testMapper;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("-sdf-sd=f7897987");
		return testProperties.getTitle();
	}
	
	@RequestMapping("/db/get")
	public User get(){
		return userRepository.findByUserName("aa1");
	}
	
	@RequestMapping("/redis/get")
	public String redisGet(){
		stringRedisTemplate.opsForValue().set("key", "test");
		
		return stringRedisTemplate.opsForValue().get("key");
	}
	
	@RequestMapping("/redis/session")
	public String redisSession(HttpSession session){
		
		UUID uuid = (UUID) session.getAttribute("uuid");
		if(uuid == null){
			uuid = UUID.randomUUID();
		}
		
		session.setAttribute("uuid", uuid);
		return session.getId();
	}
	
	@RequestMapping("/mybatis/get")
	public Test mybatisGet(){
		
		Test test = new Test();
		test.setName("45ddd");
		test.setSex(0);
		testMapper.insert(test);
		
		return test;
	}
}
