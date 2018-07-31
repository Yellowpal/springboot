package win.yellowpal.springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import win.yellowpal.springboot.domain.Test;

public interface TestMapper {

	@Select("select * from test where id=#{id}")
	public Test getById(@Param("id")long id);
	
	@Insert("insert into test(name,sex) values(#{name},#{sex})")
	public void insert(Test test);
}
