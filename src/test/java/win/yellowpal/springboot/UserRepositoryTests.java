package win.yellowpal.springboot;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import win.yellowpal.springboot.dao.UserRepository;
import win.yellowpal.springboot.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() throws Exception {

		System.out.println(userRepository.findByUserName("aa1"));
	}
}
