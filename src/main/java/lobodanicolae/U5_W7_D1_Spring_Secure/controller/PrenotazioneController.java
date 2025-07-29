package lobodanicolae.U5_W7_D1_Spring_Secure.controller;

import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.PrenotazionePayload;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Prenotazione;
import lobodanicolae.U5_W7_D1_Spring_Secure.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService service;

    @GetMapping
    public List<Prenotazione> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public Prenotazione create(@RequestBody @Validated PrenotazionePayload payload) {
        return service.save(payload);
    }

    @PutMapping("/{id}")
    public Prenotazione update(@PathVariable UUID id, @RequestBody @Validated PrenotazionePayload payload) {
        return service.update(id, payload);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
