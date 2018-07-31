package win.yellowpal.springboot.domain;

import java.io.Serializable;

public class Test implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -794379286585146938L;

	private long id;
	
	private String name;
	
	private int sex;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
