package no.ssb.api.ssbbilapi.controller;

import no.ssb.api.ssbbilapi.domain.Ansatt;
import no.ssb.api.ssbbilapi.repository.AnsattRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class AnsattController {
    @Autowired
    AnsattRepository ansattRepository;

    @PostMapping("/ansatte")
    public ResponseEntity<?> insertAnsatte(@RequestBody ArrayList<Ansatt> ansatte) {
        return new ResponseEntity<>(ansattRepository.saveAll(ansatte), HttpStatus.OK);
    }

}
