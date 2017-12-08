package RelationalMapping.componentMapping;


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

public class componentmap {
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
   public void test() {
	   Session session = sessionFactory.openSession();
	    session.beginTransaction();
		  
	    Wife wife = new Wife();
	    wife.setAge(18);
	    wife.setWifeName("wife");
		Husband husband = new Husband();
		husband.setId(1);
		husband.setName("husname");
		husband.setWife(wife);
		
		session.save(husband);
		
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
