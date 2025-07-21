package dy.anotherDb;

/**
 * Hello world!
 *
 */
import dy.anotherDb.StudentDao;
import dy.anotherDb.model.*;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        StudentDao studentdao=new StudentDao();
        Student student =new Student("maaj", "bhad","maaj@gmail.com");
        studentdao.saveStudent(student);
        System.out.println(student);
    }
}
