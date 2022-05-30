package eb.study.springstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.InsuranceTypeDto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class InsuranceTypeCotrollerTest {

    private Logger log = LoggerFactory.getLogger(InsuranceTypeCotrollerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InsuranceTypeCotroller insuranceTypeCotroller;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(insuranceTypeCotroller).build();
    }

    private List<InsuranceTypeDto> generate(){
        List<InsuranceTypeDto> insuranceTypeDtos = new ArrayList<>();
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(1L).type("OC").cost("420").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(2L).type("OC").cost("350").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(3L).type("OC").cost("475").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(4L).type("OC").cost("400").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(5L).type("OC").cost("450").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(6L).type("AC").cost("410").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(7L).type("AC").cost("420").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(8L).type("AC").cost("430").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(9L).type("AC").cost("440").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(10L).type("AC").cost("450").build());

        return insuranceTypeDtos;
    }

    @Test
    void saveInsurances() {
        try {
            String json = new ObjectMapper().writeValueAsString(generate());
            MvcResult mvcResult = mockMvc.perform(post("/study/insurancetype/saveInsurances").content(json).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            assertEquals(mvcResult.getResponse().getStatus(), 200);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}