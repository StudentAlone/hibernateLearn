package cn.lao.pkannotation;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 注解形式的联合主键：
 * 方式1：引入外部类（该类由联合主键组成），作为属性，在该属性上使用注解  @EmbeddedId
 * 方式2：引入外部类作为属性，在该属性上使用@Id,同时在外部类上使用@@Embeddable
 * 方式3：建一个外部类，不用引入，在主类上使用@@IdClass(外部类.class)，同时在主类需要加入联合主键属性
 * ，在主键属性上使用@Id
 * 共性：外部都需要实现Serializable接口，并重写hashCode和equals方法
 * @author Administrator
 *
 */

@Entity
@Table(name = "studentannotation2", schema = "hibernate_demo")
@IdClass(StudentPKannotation.class)
public class Studentannotation {

	/*
	 * @EmbeddedId private StudentPKannotation pk;
	 */
	@Id
	private int id;
	@Id
	private String name;
	private int age;
	private String sex;
	private boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public StudentPKannotation getPk() { return pk; } public void
	 * setPk(StudentPKannotation pk) { this.pk = pk; }
	 */
}
