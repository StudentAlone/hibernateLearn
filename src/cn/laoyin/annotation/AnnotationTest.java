package cn.laoyin.annotation;
import org.junit.Test;

import cn.lao.hibernateUtils.HibernateUtils;

public class AnnotationTest{
	@Test
	public void Location_embed_otherClass_Test() {
	    HibernateUtils.before();
		City c = new City("c001", "New York");
		Location_embed_otherClass o = new Location_embed_otherClass("p0001", "jffssssf", c);
		HibernateUtils.after(o);
	}
	
}
