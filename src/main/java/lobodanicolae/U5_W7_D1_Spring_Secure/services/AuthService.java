package lobodanicolae.U5_W7_D1_Spring_Secure.services;


import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.LoginDTO;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import lobodanicolae.U5_W7_D1_Spring_Secure.exceptions.UnauthorizedException;
import lobodanicolae.U5_W7_D1_Spring_Secure.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {
        Dipendente found = dipendenteService.findByEmail(body.email());
        if (passwordEncoder.matches(body.password(), found.getPassword())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Credenziali errate");
        }
    }

}
