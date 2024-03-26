package PS26792_Lab7.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

public interface JsonWebTokenService{
	String extractUsername(String token);
	String generateToken(UserDetails userDetails);
	boolean isToKenValid(String token ,UserDetails userDetails);

}
