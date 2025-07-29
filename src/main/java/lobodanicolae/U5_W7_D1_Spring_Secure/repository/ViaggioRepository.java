package lobodanicolae.U5_W7_D1_Spring_Secure.repository;


import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {
}
