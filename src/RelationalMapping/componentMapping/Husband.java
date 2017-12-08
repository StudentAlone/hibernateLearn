package RelationalMapping.componentMapping;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 注解要么都放在属性上，要么都放在get方法上
 * @author Administrator
 *
 */

@Entity
public class Husband {
	
	private int id;
	private String name;
	
	private Wife wife;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	@Embedded
	@AttributeOverride(name="address" , column= @Column(name="wwa"))
	public Wife getWife() {
		return wife;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
}
