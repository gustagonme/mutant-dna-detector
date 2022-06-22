package com.mutant.dna.detector.service;

import com.mutant.dna.detector.exception.MutantDnaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantDnaServiceTest {

    @InjectMocks
    private MutantDnaService mutantDnaService;

    @Test(expected = NullPointerException.class)
    public void isMutant(){
        MutantDnaException mde = new MutantDnaException(HttpStatus.OK, "Hemos encontrado un mutante");
        String [] sample = {"ATGTGA", "CAGTGC", "TTATGT", "AGAGCG", "CCCGTA", "TGTCTC"};
        List<String> dna = Arrays.asList(sample);
        System.out.println(dna);
        Mockito.when(mutantDnaService.isMutant(dna)).thenReturn(mde);
    }
}
