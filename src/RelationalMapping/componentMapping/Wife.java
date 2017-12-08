package RelationalMapping.componentMapping;

import javax.persistence.Embeddable;


public class Wife {
	
	private String wifeName;
	private int age;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String name) {
		this.wifeName = name;
	}
	
}
