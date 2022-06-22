package com.mutant.dna.detector.service;
import com.mutant.dna.detector.dto.DnaStatus;
import com.mutant.dna.detector.repository.DnaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DnaStatusService {
    @Autowired
    private DnaStatusRepository dnaStatusRepository;

    public List<DnaStatus> Status(){
        try{
            return dnaStatusRepository.dnaStatus();
        }catch(Exception e){
            DnaStatus ds = new DnaStatus();
            ds.setHumans(0);
            ds.setMutants(0);
            ds.setRatio(0.0);
            List<DnaStatus> response = new ArrayList<>();
            response.add(new DnaStatus(ds.getHumans(), ds.getMutants(), ds.getRatio()));
            return response;
        }

    }
}
