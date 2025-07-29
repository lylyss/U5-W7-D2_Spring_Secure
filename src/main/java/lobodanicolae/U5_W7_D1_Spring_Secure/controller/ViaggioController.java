package lobodanicolae.U5_W7_D1_Spring_Secure.controller;

import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.ViaggioPayload;
import lobodanicolae.U5_W7_D1_Spring_Secure.entities.Viaggio;
import lobodanicolae.U5_W7_D1_Spring_Secure.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService service;

    //---------------get all------------------
    @GetMapping
    public List<Viaggio> getAll() {
        return service.findAll();
    }//end find all

    //--------------------------get id--------------------------------
    @GetMapping("/{id}")
    public Viaggio getById(@PathVariable UUID id) {
        return service.findById(id);
    }// end find id

    //---------------------create------------------------

    @PostMapping
    public Viaggio create(@RequestBody @Validated ViaggioPayload payload) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(payload.destinazione());
        viaggio.setData(payload.data());
        viaggio.setStato(payload.stato() != null ? payload.stato() : "IN_CORSO");
        return service.save(viaggio);
    }

    //---------------------cambio stato------------------
    @PatchMapping("/{id}/completa")
    public Viaggio completaViaggio(@PathVariable UUID id) {
        return service.completaViaggio(id);
    }

    //----------------------update----------------------------

    @PutMapping("/{id}")
    public ViaggioPayload update(@PathVariable UUID id, @RequestBody @Validated ViaggioPayload payload) {
        Viaggio viaggio = service.findById(id);
        viaggio.setDestinazione(payload.destinazione());
        viaggio.setData(payload.data());
        viaggio.setStato(payload.stato() != null ? payload.stato() : "IN_CORSO");
        Viaggio updated = service.save(viaggio);
        return new ViaggioPayload(updated.getId(), updated.getDestinazione(), updated.getData(), updated.getStato());
    }

    //-----------------------------------delete----------------------------

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
