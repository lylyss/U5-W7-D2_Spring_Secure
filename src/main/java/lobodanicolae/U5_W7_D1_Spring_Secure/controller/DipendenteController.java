package lobodanicolae.U5_W7_D1_Spring_Secure.controller;

import jakarta.validation.Valid;
import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.DipendentePayload;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Dipendente;
import lobodanicolae.U5_W7_D1_Spring_Secure.services.DipendenteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    private final DipendenteService service;

    public DipendenteController(DipendenteService service) {
        this.service = service;
    }

    // --------------------------------------get all------------------------------------------
    @GetMapping
    public List<DipendentePayload> getAll() {
        return service.findAll().stream()
                .map(dipendente -> new DipendentePayload(
                        dipendente.getId(),
                        dipendente.getUsername(),
                        dipendente.getNome(),
                        dipendente.getCognome(),
                        dipendente.getEmail(),
                        dipendente.getImmagineProfiloPath())).toList();
    }//fine get all

    // --------------------------------------get id------------------------------------------

    @GetMapping("/{id}")
    public DipendentePayload getById(@PathVariable UUID id) {
        Dipendente dipendente = service.findById(id);
        return new DipendentePayload(
                dipendente.getId(),
                dipendente.getUsername(),
                dipendente.getNome(),
                dipendente.getCognome(),
                dipendente.getEmail(),
                dipendente.getImmagineProfiloPath());
    }//fine get id

    // --------------------------------------create------------------------------------------
    @PostMapping
    public DipendentePayload create(@RequestBody @Valid DipendentePayload payload) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(payload.username());
        dipendente.setNome(payload.nome());
        dipendente.setCognome(payload.cognome());
        dipendente.setEmail(payload.email());
        dipendente.setImmagineProfiloPath(payload.immagineProfiloPath());
        Dipendente salvato = service.save(dipendente);
        return new DipendentePayload(
                salvato.getId(),
                salvato.getUsername(),
                salvato.getNome(),
                salvato.getCognome(),
                salvato.getEmail(),
                salvato.getImmagineProfiloPath()
        );
    }// end create

    //--------------------------------------update-------------------------------------------

    @PutMapping("/{id}")
    public DipendentePayload update(@PathVariable UUID id, @RequestBody @Valid DipendentePayload payload) {
        Dipendente dipendente = service.findById(id);
        dipendente.setUsername(payload.username());
        dipendente.setNome(payload.nome());
        dipendente.setCognome(payload.cognome());
        dipendente.setEmail(payload.email());
        dipendente.setImmagineProfiloPath(payload.immagineProfiloPath());
        Dipendente updated = service.save(dipendente);
        return new DipendentePayload(updated.getId(), updated.getUsername(), updated.getNome(), updated.getCognome(), updated.getEmail(), updated.getImmagineProfiloPath());
    }//end update

    //---------------------------------------------------------inserimento immagini--------------------------------

    @PatchMapping("/{id}/avatar")
    public String uploadImage(
            @PathVariable UUID id,
            @RequestParam("avatar") MultipartFile file
    ) throws IOException {
        return service.uploadAvatar(id, file);
    }


    // --------------------------------------delete------------------------------------------
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
