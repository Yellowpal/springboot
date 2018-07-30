package win.yellowpal.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import win.yellowpal.springboot.conf.TestProperties;
import win.yellowpal.springboot.dao.UserRepository;
import win.yellowpal.springboot.domain.User;

@RestController
public class HelloController {
	
	@Autowired
	private TestProperties testProperties;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("-sdf-sd=f7897987");
		return testProperties.getTitle();
	}
	
	@RequestMapping("/db/get")
	public User get(){
		return userRepository.findByUserName("aa1");
	}
}
