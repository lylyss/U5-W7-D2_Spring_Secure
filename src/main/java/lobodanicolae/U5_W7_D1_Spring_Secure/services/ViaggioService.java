package lobodanicolae.U5_W7_D1_Spring_Secure.services;

import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Viaggio;
import lobodanicolae.U5_W7_D1_Spring_Secure.exceptions.ResourceNotFoundException;
import lobodanicolae.U5_W7_D1_Spring_Secure.repository.ViaggioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {
    private final ViaggioRepository repository;

    public ViaggioService(ViaggioRepository repository) {
        this.repository = repository;
    }

    public List<Viaggio> findAll() {
        return repository.findAll();
    }

    public Viaggio save(Viaggio viaggio) {
        return repository.save(viaggio);
    }

    public Viaggio findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Viaggio non trovato con id: " + id));
    }


    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Viaggio completaViaggio(UUID id) {
        Viaggio viaggio = this.findById(id);
        viaggio.setStato("COMPLETATO");
        return repository.save(viaggio);
    }

}
