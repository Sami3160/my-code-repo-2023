package dy.autowireExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.supp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	ApplicationContext context=new ClassPathXmlApplicationContext("dy/autowireExample/AutoConfig.xml");
    	Emp e1=context.getBean("emp1", Emp.class);
    	System.out.println(e1);
    }
}
