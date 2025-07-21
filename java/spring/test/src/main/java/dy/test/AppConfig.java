 
package dy.test;
import org.springframework.context.annotation.*;
//import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="dy.test")
public class AppConfig {
	@Bean("User1")
	public User getUser1() {
		return new User(3, "Ramesh");
	}
	
	@Bean("User2")
	public User getUser2() {
		return new User(4, "Sachin");
	}
	
	
}
