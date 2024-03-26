package PS26792_Lab7.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PS26792_Lab7.Entities.Role;
import PS26792_Lab7.Entities.User;



@Repository
public interface UserRePository extends JpaRepository<User,Long>{
	 Optional<User> findByEmail(String email);
	 
	 User findByRole(Role role);
}
