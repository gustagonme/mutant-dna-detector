package com.mutant.dna.detector.service;

import com.mutant.dna.detector.exception.MutantDnaException;
import com.mutant.dna.detector.factory.impl.CheckHorizontalSequence;
import com.mutant.dna.detector.factory.impl.CheckObliqueSequence;
import com.mutant.dna.detector.factory.impl.CheckVerticalSequence;
import com.mutant.dna.detector.model.DnaSamples;
import com.mutant.dna.detector.repository.DnaSamplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MutantDnaService {
    @Autowired
    private CheckHorizontalSequence checkHorizontalSequence;

    @Autowired
    private CheckVerticalSequence checkVerticalSequence;

    @Autowired
    private CheckObliqueSequence checkObliqueSequence;

    @Autowired
    private DnaSamplesRepository dnaSamplesRepository;


    private static final List<Boolean> handler = new ArrayList<Boolean>();

    private List<Boolean> getCheckDna(String [] dna){
        handler.clear();
        handler.add(checkHorizontalSequence.validateDna(dna));
        handler.add(checkVerticalSequence.validateDna(dna));
        handler.add(checkObliqueSequence.validateDna(dna));
        return handler;
    }

    public MutantDnaException isMutant (List<String> dna){
        String [] dnaSample = formatDnaSample(dna);
        boolean isMutant = DnaMatchSequence(getCheckDna(dnaSample));
        System.out.println(isMutant);
        dnaSamplesRepository.save(new DnaSamples(String.join(",", dnaSample), isMutant));
        return isMutant ? new MutantDnaException(HttpStatus.OK, "Hemos encontrado un mutante") : new MutantDnaException(HttpStatus.FORBIDDEN, "El sujeto de pruebas es humano");
    }

    private static String [] formatDnaSample (List<String> dna) {
        String[] sample = dna.stream()
                .map(l -> l)
                .toArray(String[]::new);
        return sample;
    }

    private static Boolean DnaMatchSequence(List<Boolean> checkDna){
        System.out.println(checkDna);
        long count = checkDna.stream().filter(p -> p == true).count();
        System.out.println(count);
        return count > 1 ? true : false;
    }

}
