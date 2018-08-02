package win.yellowpal.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import win.yellowpal.springboot.dao.UserInfoDao;
import win.yellowpal.springboot.domain.UserInfo;

@Service
public class UserInfoService {

	
	@Autowired
	UserInfoDao userInfoDao;
	
	public UserInfo findByUsername(String username){
		
		return userInfoDao.findByUsername(username);
	}
}
