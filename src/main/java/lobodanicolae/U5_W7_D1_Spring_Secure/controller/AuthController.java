package lobodanicolae.U5_W7_D1_Spring_Secure.controller;

import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.LoginDTO;
import lobodanicolae.U5_W7_D1_Spring_Secure.services.AuthService;
import lobodanicolae.U5_W7_D1_Spring_Secure.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/login")
    public LoginDTO login(@RequestBody LoginDTO body) {
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginDTO(accessToken);
    }
}
