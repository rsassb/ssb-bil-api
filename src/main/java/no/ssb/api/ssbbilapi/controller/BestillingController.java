package no.ssb.api.ssbbilapi.controller;

import no.ssb.api.ssbbilapi.domain.Bestilling;
import no.ssb.api.ssbbilapi.repository.BestillingRepository;
import no.ssb.api.ssbbilapi.utils.Dato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class BestillingController {
    @Autowired
    BestillingRepository bestillingRepository;

    @PostMapping("/bestillinger")
    public ResponseEntity<?> insertBestillinger(@RequestBody ArrayList<Bestilling> bestillinger) {
        return new ResponseEntity<>(bestillingRepository.saveAll(bestillinger), HttpStatus.OK);
    }

    @PutMapping("/bestilling")
    public ResponseEntity<?> updateBestilling(@RequestBody Bestilling bestilling) {
        return new ResponseEntity<>(bestillingRepository.save(bestilling), HttpStatus.OK);
    }

    @GetMapping("/bestilling/{id}}")
    public ResponseEntity<?> getBestilling(@PathVariable Long id) {
        return new ResponseEntity<>(bestillingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/bestilling/passasjer/{initialer}")
    public ResponseEntity<?> getBestillingerForPassasjer(@PathVariable String initialer) {
        return new ResponseEntity<>(bestillingRepository.findAllByPassasjer(initialer), HttpStatus.OK);
    }

    @GetMapping("/bestilling/dato/{dato}")
    public ResponseEntity<?> getBestillinger(@PathVariable String dato) {
        try {
            return new ResponseEntity<>(bestillingRepository.findAllByDato(
                    (dato != null && dato.length() > 0) ?
                            Dato.StringToDate(dato) : LocalDate.now()), HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/bestilling/{id}")
    public ResponseEntity<?> deleteBestilling(@PathVariable Long id) {
        try {
            bestillingRepository.deleteById(id);
            return new ResponseEntity<>("Avbestilling utført", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
