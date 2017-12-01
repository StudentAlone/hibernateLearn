package cn.lao.pkxml;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateIDTest {
	 private static SessionFactory sessionFactory;
	 
	 @BeforeClass
	 public static void beforeClass() {
		//创建服务注册对象
         StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure() // configures settings from hibernate.cfg.xml
    			.build();
    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	 }
    @AfterClass
	 public static void afterClass() {
	  sessionFactory.close();
	 }
	 
	 @Test
	 public void testStudentSave() {
	  StudentPK pk = new StudentPK();
	  pk.setId(5);
	  pk.setName("zhangsan5");
	  Student s = new Student();
	  s.setPk(pk);
	  s.setAge(8);
	  
	  
	  Session session = sessionFactory.getCurrentSession();
	  session.beginTransaction();
	  session.save(s);
	  session.getTransaction().commit();
	 }
	 
	 public static void main(String[] args) {
	  beforeClass();
	 }
	}