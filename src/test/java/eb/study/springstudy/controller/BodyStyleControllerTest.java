package eb.study.springstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.BodyStyleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BodyStyleControllerTest{
    final Logger log = LoggerFactory.getLogger(BodyStyleControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BodyStyleController bodyStyleController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(bodyStyleController).build();
    }

    public List<BodyStyleDto> generate(){
        List<BodyStyleDto> bodyStyleDtos = new ArrayList<>();
        bodyStyleDtos.add(BodyStyleDto.builder().id(1L).style("Buggy").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(2L).style("Cabriolet").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(3L).style("Pickup").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(4L).style("Panel van").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(5L).style("Estate car").doorNumber(5).build());

        bodyStyleDtos.add(BodyStyleDto.builder().id(6L).style("Hearse").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(7L).style("Flower car").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(8L).style("Microvan").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(9L).style("Minivan").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(10L).style("Panel van").doorNumber(2).build());

        return bodyStyleDtos;
    }


    @Test
    void saveBodyStyles() {
        try {
            String json = new ObjectMapper().writeValueAsString(generate());

            long start1 = System.nanoTime();
            MvcResult mvcResult = mockMvc.perform(post("/study/bodystyle/saveBodyStyles")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long end1 = System.nanoTime();
            System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));
            assertEquals(mvcResult.getResponse().getStatus(), 200);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}