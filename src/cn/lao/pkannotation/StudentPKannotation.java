package cn.lao.pkannotation;

import javax.persistence.Embeddable;
import javax.persistence.Id;


public class StudentPKannotation implements java.io.Serializable {
	private int id;
	private String name;

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

	@Override
	public boolean equals(Object o) {
		if (o instanceof StudentPKannotation) {
			StudentPKannotation pk = (StudentPKannotation) o;
			if (this.id == pk.getId() && this.name.equals(pk.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}