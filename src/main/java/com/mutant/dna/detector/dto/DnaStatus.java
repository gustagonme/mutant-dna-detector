package com.mutant.dna.detector.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DnaStatus {

    @Id
    private int mutants;
    @Column(name="humans")
    private int humans;
    @Column(name="ratio")
    private double ratio;

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public DnaStatus() {
    }

    public int getMutants() {
        return mutants;
    }

    public void setMutants(int mutants) {
        this.mutants = mutants;
    }

    public int getHumans() {
        return humans;
    }

    public void setHumans(int humans) {
        this.humans = humans;
    }
}
