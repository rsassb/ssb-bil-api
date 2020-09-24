package no.ssb.api.ssbbilapi.controller;

import no.ssb.api.ssbbilapi.domain.Sete;
import no.ssb.api.ssbbilapi.repository.SeteRepository;
import no.ssb.api.ssbbilapi.utils.Dato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class SeteController {
    @Autowired
    SeteRepository seteRepository;

    @PostMapping("/seter")
    public ResponseEntity<?> insertSeter(@RequestBody ArrayList<Sete> seter) {
        return new ResponseEntity<>(seteRepository.saveAll(seter), HttpStatus.OK);
    }

    @GetMapping("/sete/{dato}")
    public ResponseEntity<?> getSeteForDato(@PathVariable String dato) {
        try {
        return new ResponseEntity<>(seteRepository.findForDato(
                (dato != null && dato.length() > 0) ? Dato.StringToDate(dato) : LocalDate.now()),
                HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
