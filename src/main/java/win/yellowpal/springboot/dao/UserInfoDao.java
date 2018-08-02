package win.yellowpal.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import win.yellowpal.springboot.domain.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}