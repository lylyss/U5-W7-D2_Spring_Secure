package lobodanicolae.U5_W7_D1_Spring_Secure.repository;

import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByUsername(String username);

    Optional<Dipendente> findByEmail(String email);
}