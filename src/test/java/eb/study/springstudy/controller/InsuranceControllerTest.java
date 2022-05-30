package eb.study.springstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.InsuranceDto;
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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class InsuranceControllerTest {
    private Logger log = LoggerFactory.getLogger(InsuranceControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InsuranceController insuranceController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(insuranceController).build();
    }

    private List<InsuranceDto> generate() {
        List<InsuranceDto> insuranceDtos = new ArrayList<>();
        insuranceDtos.add(InsuranceDto.builder().id(1L).startDate(Date.valueOf("2010-01-01")).expiration(Date.valueOf("2011-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(2L).startDate(Date.valueOf("2011-01-01")).expiration(Date.valueOf("2012-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(4L).startDate(Date.valueOf("2013-01-01")).expiration(Date.valueOf("2014-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(5L).startDate(Date.valueOf("2014-01-01")).expiration(Date.valueOf("2015-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(6L).startDate(Date.valueOf("2015-01-01")).expiration(Date.valueOf("2016-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(7L).startDate(Date.valueOf("2016-01-01")).expiration(Date.valueOf("2017-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(3L).startDate(Date.valueOf("2012-01-01")).expiration(Date.valueOf("2013-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(8L).startDate(Date.valueOf("2017-01-01")).expiration(Date.valueOf("2018-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(9L).startDate(Date.valueOf("2018-01-01")).expiration(Date.valueOf("2019-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(10L).startDate(Date.valueOf("2019-01-01")).expiration(Date.valueOf("2020-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());

        return insuranceDtos;
    }

    @Test
    void saveInsurances() {
        try {
            String json = new ObjectMapper().writeValueAsString(generate());
            MvcResult mvcResult = mockMvc.perform(post("/study/insurance/saveInsurances")
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            assertEquals(mvcResult.getResponse().getStatus(), 200);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}