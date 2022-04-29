package com.store.bookstore.security.jwt;


import com.store.bookstore.security.UserPrincipal;
import com.store.bookstore.util.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

i
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider implements IJwtProvider {
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Value("${jwt.expiration.ms}")
    private String JWT_EXPIRATION_MS;

    public String generateTOken(UserPrincipal auth) {
        String authorities = auth.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());
        return Jwts
                .builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

    public Authentication getAuthentication(HttpServletRequest request){
Claims claims = extractClaim(request);

String username = claims.getSubject();
Long userId = claims.get("userId" , Long.class);
    }

    public Claims extractClaim(HttpServletRequest request){
        String token = SecurityUtils.extractAuthTokenFromRequests(request);
        if(token == null ){
            return null;
        }
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


}
