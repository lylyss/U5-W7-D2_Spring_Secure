package lobodanicolae.U5_W7_D1_Spring_Secure.services;


import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.LoginDTO;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import lobodanicolae.U5_W7_D1_Spring_Secure.exceptions.UnauthorizedException;
import lobodanicolae.U5_W7_D1_Spring_Secure.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JWTTools jwtTools;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {
        Dipendente found = dipendenteService.findByEmail(body.email());
        if (found.getPassword().equals(body.password())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Credenziali errate");
        }
    }

}
