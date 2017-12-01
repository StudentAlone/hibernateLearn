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
	        //��������ע�����
	         StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	    			.configure() // configures settings from hibernate.cfg.xml
	    			.build();
	        try {
	    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	    	    session = sessionFactory.openSession();
	    	    System.out.println("�ܴ�session���Ǿ�û����");
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
			transaction.commit(); // �ύ����
			session.close(); // �رջỰ
			sessionFactory.close(); // �رջỰ����
		}
}
