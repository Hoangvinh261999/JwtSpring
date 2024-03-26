package PS26792_Lab7.Service;

import org.springframework.stereotype.Service;

import PS26792_Lab7.Entities.User;
import PS26792_Lab7.dto.SignUpRequest;

public interface AuthenticationService {
	 User signup(SignUpRequest signUpRequest);
}
