package cn.lao.pkannotation;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * ע����ʽ������������
 * ��ʽ1�������ⲿ�ࣨ����������������ɣ�����Ϊ���ԣ��ڸ�������ʹ��ע��  @EmbeddedId
 * ��ʽ2�������ⲿ����Ϊ���ԣ��ڸ�������ʹ��@Id,ͬʱ���ⲿ����ʹ��@@Embeddable
 * ��ʽ3����һ���ⲿ�࣬�������룬��������ʹ��@@IdClass(�ⲿ��.class)��ͬʱ��������Ҫ����������������
 * ��������������ʹ��@Id
 * ���ԣ��ⲿ����Ҫʵ��Serializable�ӿڣ�����дhashCode��equals����
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
