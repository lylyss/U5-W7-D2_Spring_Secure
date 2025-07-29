package lobodanicolae.U5_W7_D1_Spring_Secure.Payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ViaggioPayload(UUID id, @NotBlank String destinazione, @NotNull LocalDate data, String stato) {
}
