package com.mutant.dna.detector.service;

import com.mutant.dna.detector.dto.DnaStatus;
import com.mutant.dna.detector.repository.DnaStatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaStatusServiceTest {

    @Mock
    private DnaStatusRepository dnaStatusRepository;

    @InjectMocks
    DnaStatusService dnaStatusService;


    @Test
    public void get_status (){
        DnaStatus ds = new DnaStatus();
        ds.setHumans(0);
        ds.setMutants(0);
        ds.setRatio(0.0);
        List<DnaStatus> response = new ArrayList<>();
        response.add(new DnaStatus(ds.getHumans(), ds.getMutants(), ds.getRatio()));
        Mockito.when(dnaStatusService.Status()).thenReturn(response);
    }
}
