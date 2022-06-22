package com.mutant.dna.detector.repository;

import com.mutant.dna.detector.dto.DnaStatus;
import com.mutant.dna.detector.model.DnaSamples;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaSamplesRepository extends CrudRepository<DnaSamples, Long> {
    List<DnaSamples> findAll();
}
