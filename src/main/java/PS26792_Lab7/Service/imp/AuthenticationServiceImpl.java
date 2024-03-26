package PS26792_Lab7.Service.imp;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import PS26792_Lab7.Entities.Role;
import PS26792_Lab7.Entities.User;
import PS26792_Lab7.Repository.UserRePository;
import PS26792_Lab7.Service.AuthenticationService;
import PS26792_Lab7.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	private final UserRePository userRePository;
	private final PasswordEncoder passwordEncoder;
	public User signup(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setHoTen(signUpRequest.getEmail());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		return		userRePository.save(user);

		
	}
}
