package dy.anotherDb;
import org.hibernate.*;
import dy.anotherDb.model.*;
public class StudentDao {
	public void saveStudent(Student student) {
			Transaction transaction=null;
			try {
				Session session = hibutil.getSessionFactory().openSession();
				transaction=session.beginTransaction();
				session.save(student);
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();
				}
				
			}
	}
}


