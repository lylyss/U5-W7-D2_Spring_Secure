package lobodanicolae.U5_W7_D1_Spring_Secure.Payloads;

import java.time.LocalDateTime;

public record Errore(String message, LocalDateTime timestamp) {
}
