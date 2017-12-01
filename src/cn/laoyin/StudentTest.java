package cn.laoyin;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class StudentTest {
    private SessionFactory sessionFactory; 
    private Session session;
    private Transaction transaction;
    
    @Before
    public void before(){
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

    @After
    public void after(){
        transaction.commit();    //提交事务
        session.close();        //关闭会话
        sessionFactory.close(); //关闭会话工厂
    }
    
    @Test
    public void testSaveStudent() {
        //创建学生对象
        Student s = new Student(35,"张三","男",new Date(),"武当山");
        /*
         * 由于hibernate.cfg.xml中配置的hbm2ddl.auto值为'Create'，所以执行save
         * 方法会检查数据库中是否有student表，没有的话会创建此表，并将s对象保存进去
         */
        session.save(s);
    }

}