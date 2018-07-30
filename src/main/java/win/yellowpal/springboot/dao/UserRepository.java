package win.yellowpal.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import win.yellowpal.springboot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);
}
