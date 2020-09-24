package no.ssb.api.ssbbilapi.controller;

import no.ssb.api.ssbbilapi.domain.Parameter;
import no.ssb.api.ssbbilapi.repository.ParameterRepository;
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
public class ParameterController {
    @Autowired
    ParameterRepository parameterRepository;

    @PostMapping("/parametre")
    public ResponseEntity<?> insertParametere(@RequestBody ArrayList<Parameter> parametre) {
        return new ResponseEntity<>(parameterRepository.saveAll(parametre), HttpStatus.OK);
    }
}
