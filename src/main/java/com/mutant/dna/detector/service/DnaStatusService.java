package com.mutant.dna.detector.service;
import com.mutant.dna.detector.dto.DnaStatus;
import com.mutant.dna.detector.repository.DnaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaStatusService {
    @Autowired
    private DnaStatusRepository dnaStatusRepository;

    public List<DnaStatus> Status(){
        return dnaStatusRepository.dnaStatus();
    }
}
