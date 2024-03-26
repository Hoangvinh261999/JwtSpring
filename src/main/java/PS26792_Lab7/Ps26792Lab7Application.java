package PS26792_Lab7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import PS26792_Lab7.Entities.Role;
import PS26792_Lab7.Repository.UserRePository;
import PS26792_Lab7.Entities.User;

@SpringBootApplication
public class Ps26792Lab7Application implements CommandLineRunner{
@Autowired
private UserRePository userRePository;
	public static void main(String[] args) {
		SpringApplication.run(Ps26792Lab7Application.class, args);
	}
	
	public void run(String...args) {
		User adminAccount = userRePository.findByRole(Role.ADMIN);
		if(null== adminAccount) {
			User usernew= new User();
			usernew.setEmail("kuteboy99@gmail.com");
			usernew.setHoTen("adminvinh");
			usernew.setRole(Role.ADMIN);
			usernew.setPassword(new BCryptPasswordEncoder().encode("vinh99"));
			userRePository.save(usernew);
			
		}
		
		
	}
}
