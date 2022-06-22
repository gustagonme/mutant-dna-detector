package com.mutant.dna.detector.repository;
import com.mutant.dna.detector.dto.DnaStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DnaStatusRepository extends CrudRepository<DnaStatus, Long> {

    @Query(value = "select m.*, h.*, trunc((cast (m.mutants as decimal)/h.humans),2) as ratio " +
            "from (select count(is_mutant) as mutants from dna_samples where is_mutant = true) m, " +
            "(select count(is_mutant) as humans from dna_samples where is_mutant = false) h", nativeQuery=true)
    List<DnaStatus> dnaStatus();
}
