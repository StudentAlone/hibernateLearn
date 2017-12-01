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

    @After
    public void after(){
        transaction.commit();    //�ύ����
        session.close();        //�رջỰ
        sessionFactory.close(); //�رջỰ����
    }
    
    @Test
    public void testSaveStudent() {
        //����ѧ������
        Student s = new Student(35,"����","��",new Date(),"�䵱ɽ");
        /*
         * ����hibernate.cfg.xml�����õ�hbm2ddl.autoֵΪ'Create'������ִ��save
         * �����������ݿ����Ƿ���student��û�еĻ��ᴴ���˱�����s���󱣴��ȥ
         */
        session.save(s);
    }

}