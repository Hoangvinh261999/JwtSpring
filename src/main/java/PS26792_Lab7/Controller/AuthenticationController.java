package PS26792_Lab7.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PS26792_Lab7.Entities.User;
import PS26792_Lab7.Service.AuthenticationService;
import PS26792_Lab7.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationService authenticationService;
	@PostMapping("/signup")
	public ResponseEntity<User> singup(@RequestBody SignUpRequest signUpRequest){
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
}	
