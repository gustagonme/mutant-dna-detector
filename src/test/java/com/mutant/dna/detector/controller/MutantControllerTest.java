package com.mutant.dna.detector.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    String requestMutant = "{\n"+
            "\"dna\": " +
            "        [\"ATGCGA\",\n" +
            "         \"CAGTGC\",\n" +
            "         \"TTATGT\",\n" +
            "         \"AGAAGG\",\n" +
            "         \"CCCCTA\",\n" +
            "         \"TCACTG\"" +
            "        ]\n" +
            "}";

    String requestHuman = "{\n"+
            "\"dna\": " +
            "        [\"ATGTGA\",\n" +
            "         \"CAGTGC\",\n" +
            "         \"TTATGT\",\n" +
            "         \"AGAGCG\",\n" +
            "         \"CCCGTA\",\n" +
            "         \"TGTCTC\"" +
            "        ]\n" +
            "}";


    @Test
    public void create_mutant() throws  Exception{
        mockMvc.perform(
                post("/mutant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestMutant.getBytes()))
                .andExpect(status().isOk());
    }

    @Test
    public void create_human() throws  Exception{
        mockMvc.perform(
                        post("/mutant/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestHuman.getBytes()))
                .andExpect(status().isForbidden());
    }

    @Test
    public void get_status() throws  Exception{
        mockMvc.perform(
                get("/mutant/status")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
