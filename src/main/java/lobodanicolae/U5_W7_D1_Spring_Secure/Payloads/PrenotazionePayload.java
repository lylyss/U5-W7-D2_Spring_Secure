package lobodanicolae.U5_W7_D1_Spring_Secure.Payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazionePayload(UUID id, @NotNull UUID viaggioId, @NotNull UUID dipendenteId,
                                  @NotNull LocalDate dataPrenotazione, String note) {
}
