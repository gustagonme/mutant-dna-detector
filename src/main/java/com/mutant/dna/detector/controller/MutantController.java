package com.mutant.dna.detector.controller;

import com.mutant.dna.detector.domain.DnaValidationRequest;
import com.mutant.dna.detector.dto.DnaStatus;
import com.mutant.dna.detector.exception.MutantDnaException;
import com.mutant.dna.detector.service.DnaStatusService;
import com.mutant.dna.detector.service.MutantDnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    MutantDnaService mutantDnaService;
    @Autowired
    DnaStatusService dnaStatusService;

        @PostMapping ("/")
        public ResponseEntity<Object> isMutant(@RequestBody DnaValidationRequest dna){
            return buildResponseEntity(mutantDnaService.isMutant(dna.getDna()));
        }

    @GetMapping("/status")
    public List<DnaStatus> Status(){
        return dnaStatusService.Status();
    }

    private ResponseEntity<Object> buildResponseEntity(MutantDnaException mutantDnaException) {
        return new ResponseEntity<>(mutantDnaException, mutantDnaException.getStatus());
    }
}
