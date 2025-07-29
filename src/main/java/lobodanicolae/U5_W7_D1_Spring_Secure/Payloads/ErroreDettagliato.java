package lobodanicolae.U5_W7_D1_Spring_Secure.Payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErroreDettagliato(String message, LocalDateTime timestamp, List<String> details) {
}
