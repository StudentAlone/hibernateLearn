package cn.lao.hibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;

public class HibernateUtils {
	    private static SessionFactory sessionFactory; 
	    private static Session session;
	    private static Transaction transaction;
	    
	    public static void before(){
	        //创建服务注册对象
	         StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	    			.configure() // configures settings from hibernate.cfg.xml
	    			.build();
	        try {
	    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	    	    session = sessionFactory.openSession();
	    	    System.out.println("能打开session，那就没错了");
	        }
	    	catch (Exception e) {
	    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
	    		// so destroy it manually.
	    		StandardServiceRegistryBuilder.destroy( registry );
	    	}
	         transaction = session.beginTransaction();
	    }
		public static void after(Object o) {
			session.save(o);
			transaction.commit(); // 提交事务
			session.close(); // 关闭会话
			sessionFactory.close(); // 关闭会话工厂
		}
}
