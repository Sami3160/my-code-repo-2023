package dy.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//with xml beans
//    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
//    	Customer  cu=(Customer) context.getBean("cust1");
//    	System.out.println(cu);
    	
    	
    	
    	//with java beans
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	User ur=context.getBean("User1", User.class);
    	System.out.println(ur);
    	
    }
}
