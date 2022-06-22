package com.mutant.dna.detector.domain;


import java.util.List;

public class DnaValidationRequest {

    private List<String> dna;

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
