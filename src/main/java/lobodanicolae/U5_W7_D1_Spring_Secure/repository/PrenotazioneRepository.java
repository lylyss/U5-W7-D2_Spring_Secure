package lobodanicolae.U5_W7_D1_Spring_Secure.repository;


import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    boolean existsByDipendenteAndDataPrenotazione(Dipendente dipendente, LocalDate dataPrenotazione);
}
