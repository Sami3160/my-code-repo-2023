package dy.sqlPractice;

import org.hibernate.Transaction;


import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
    	System.out.println( "Hello World!" );
        SessionFactory fact=cfg.buildSessionFactory();
        User us=new User();
        us.setUsername("sami");
        System.out.println(us);
        Session session=fact.openSession();
        Transaction tx=session.beginTransaction();
        session.save(us);
        System.out.println(us);
        tx.commit();
    }
}
