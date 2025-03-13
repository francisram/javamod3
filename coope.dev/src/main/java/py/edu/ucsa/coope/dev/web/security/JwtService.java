package py.edu.ucsa.coope.dev.web.security;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	@Value("${application.security.jwt.secret-key}")
	private String secretKey;
	@Value("${application.security.jwt.expiration}")
	private long jwtExpiration;
	@Value("${application.security.jwt.refresh-token.expiration}")
	private long refreshExpiration; 
	
	
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}


	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public String generarToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("catastro", "catastro");
		System.out.println("ENTRO ACA....");
		return generarToken(claims,userDetails);
	}


	public String generarToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		
		return buildtoken(extraClaims,userDetails,jwtExpiration);
	}

	public String generarRefreshToken(UserDetails userDetails) {
		return buildtoken(new HashMap<>(), userDetails, refreshExpiration);
	}
	

	public String buildtoken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
		// TODO Auto-generated method stub
		return Jwts.builder()
				.claims(extraClaims)
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis() + expiration))
				.signWith(getSignInKey(),Jwts.SIG.HS256)
				.claim("nam", "admin")
				.header().type("JWT")
				.and().compact();
				
	}

	
	public boolean isTokenValid(String token , UserDetails userDetails) {
		final String username =  extractUserName(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {

		return extractClaim(token,Claims::getExpiration);
	}

	
	private Claims extractAllClaims(String token) {

		return (Claims) Jwts.parser().verifyWith(getSignInKey()).build().parse(token).getPayload();
	}


	private SecretKey getSignInKey() {
		
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		
		return Keys.hmacShaKeyFor(keyBytes);
	} 
	
	
	

}
