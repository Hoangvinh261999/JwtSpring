package PS26792_Lab7.Service.imp;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtImplement implements PS26792_Lab7.Service.JsonWebTokenService{
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getSignKey(),SignatureAlgorithm.HS256)
				.compact();
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> ClaimsResolver){
		final Claims claims= extractAllClaims(token);
		return ClaimsResolver.apply(claims);
	}
	
	private Key getSignKey() {
		byte [] key= Decoders.BASE64.decode("haychonkeydung");
		 return Keys.hmacShaKeyFor(key);
		
	}
	
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}
	
	public String extractUsername(String token) {
	    return extractClaim(token, Claims::getSubject);
	}
public boolean isToKenValid(String token ,UserDetails userDetails) {
	final String  userName=extractUsername(token);
	return(userName.equals(userDetails.getUsername())&& !isToKenExpired(token));
	
}
public boolean isToKenExpired(String token) {
	return extractClaim(token, Claims::getExpiration).before(new Date());
	
}

	
}
