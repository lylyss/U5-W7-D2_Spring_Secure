package lobodanicolae.U5_W7_D1_Spring_Secure.tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import lobodanicolae.U5_W7_D1_Spring_Secure.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JWTTools {
    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Dipendente dipendente) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .subject(String.valueOf(dipendente.getUsername()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public void verifiedToken(String accessToken) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(accessToken);
        } catch (Exception e) {
            throw new UnauthorizedException("effettuare di nuovo il login, problemi con il token");
        }
    }
}
