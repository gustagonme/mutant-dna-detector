package com.mutant.dna.detector.model;

import javax.persistence.*;

@Entity
@Table(name="dna_samples")
public class DnaSamples {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDna;
    @Column(name = "dna")
    private String dna;
    @Column(name = "isMutant")
    private boolean isMutant;

    public DnaSamples() {
    }

    public DnaSamples(String dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    @Override
    public String toString() {
        return String.format("dna_samples[dna='%s', isMutant='%b']", dna, isMutant);
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
