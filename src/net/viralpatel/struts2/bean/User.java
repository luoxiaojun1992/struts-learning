package net.viralpatel.struts2.bean;

public class User {
	
	private String name;
	private String age;
	
	public User() {
		setName("test");
		setAge("25");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

}
