package RelationalMapping.OneToOne;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class OneToManyTest {
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
	 
    public void testotm() {
    	 Session session = sessionFactory.getCurrentSession();
  	    session.beginTransaction();
    	Phone phone3 = new Phone("3");
    	Phone phone4 = new Phone("4");
    	Phone phone5 = new Phone("5");
    	
    	List<Phone> plist=new ArrayList<Phone>();
    	plist.add(phone3);
    	plist.add(phone4);
    	plist.add(phone5);
    	
    	Person person = new Person();
    	person.setId(3L);
    	person.setPhones(plist);
 		
 		session.getTransaction().commit();
    	
    }
    
	@Test
	public void scameex() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();  
		  
		MetadataImplementor metadataImplementor = (MetadataImplementor)  
		new MetadataSources(serviceRegistry).buildMetadata();  
		  
		SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);  
		export.create(false, true);    
	}
}
