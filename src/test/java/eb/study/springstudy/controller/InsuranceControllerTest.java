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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
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

    // save:


    @Test
    void save100Insurances() {
        saveInsurancesFixedQuantityANDRepeat50Times(100);
    }

    @Test
    void save1000Insurances() {
        saveInsurancesFixedQuantityANDRepeat50Times(1000);
    }

    @Test
    void save10000Insurances() {
        saveInsurancesFixedQuantityANDRepeat50Times(10000);
    }

    //delete:

    @Test
    void delete100Insurances() {
        deleteInsurancesFixedQuantity(1, 100);
    }

    @Test
    void delete1000Insurances() {
        deleteInsurancesFixedQuantity(1, 1000);
    }

    @Test
    void delete10000Insurances() {
        deleteInsurancesFixedQuantity(1, 10000);
    }

    //update:

    @Test
    void update100Insurance() {
        updateInsuranceFixedQuantity(1, 100);
    }

    @Test
    void update1000Insurance() {
        updateInsuranceFixedQuantity(1, 1000);
    }

    @Test
    void update10000Insurance() {
        updateInsuranceFixedQuantity(1, 10000);
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




    private List<InsuranceDto> generateDefinedAmount(int amount) {
        List<InsuranceDto> dtos = new ArrayList<>();
        LocalDate localDate = LocalDate.of(2000, 1, 1);

        for(int i = 1; i <=amount; i++) {
            long fkValue = Long.valueOf(i%10 == 0 ? 10 : i%10);
            dtos.add(InsuranceDto.builder().id(Long.valueOf(i)).startDate(Date.valueOf(localDate)).expiration(Date.valueOf(localDate.plusDays(1))).fkTypeId(fkValue).fkOwnedVehicleId(fkValue).build());
            localDate = localDate.plusDays(1);
        }
        return dtos;
    }


    private void saveInsurancesFixedQuantityANDRepeat50Times(int quantity) {
        try {
            List<Long> times = new ArrayList<>();
            for(int i = 0; i < 50; i++) {
                MvcResult mvcResult = null;
                deleteFromIdToId(mvcResult, delete("/study/insurance/deleteAllInsurances"));
                String json = new ObjectMapper().writeValueAsString(generateDefinedAmount(quantity));
                long start = System.currentTimeMillis();
                mvcResult = saveInsurances(json);
                long end = System.currentTimeMillis();
                //System.out.println("Elapsed Time in nano seconds: " + (end - start));
                times.add(end-start);
                //System.out.println("time elapsed: ");
                assertEquals(mvcResult.getResponse().getStatus(), 200);

            }
            System.out.println("[saveInsurancesFixedQuantity ] Dodanie "+ quantity+" rekordów "+times.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private MvcResult saveInsurances(String json) throws Exception {
        MvcResult mvcResult;
        mvcResult = mockMvc.perform(post("/study/insurance/saveInsurances")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return mvcResult;
    }


    private void updateInsuranceFixedQuantity(Integer id1, Integer id2) {
        try {
            LocalDate date = LocalDate.parse("2010-01-01");
            List<Long> times = new ArrayList<>();
            LocalDate nextDate = date;
            MvcResult mvcResult=null;
            try {
                mvcResult = clearAndFillTableDependingOnId2(id2);
            }
            catch (Exception e){
                log.error(e.getMessage());
            }
            for(int i=0; i<50; i++){
                nextDate = nextDate.plusDays(1);
                Date startDate = Date.valueOf(nextDate);
                Date expirationDate = Date.valueOf(nextDate.plusDays(1));
                String json = new ObjectMapper().writeValueAsString(InsuranceDto.builder().id(1L).startDate(startDate).expiration(expirationDate).fkOwnedVehicleId(1L).fkTypeId(1L).build());
                long start1 = System.currentTimeMillis();
                mvcResult = deleteFromIdToId(mvcResult, post("/study/insurance/updateInsurance/"+ id1+"/"+id2)
                        .content(json));
                long end1 = System.currentTimeMillis();
                long result = end1 - start1;
                System.out.println("Elapsed Time in milli seconds: " + result);
                times.add(result);
                assertEquals(mvcResult.getResponse().getStatus(), 200);
            }
            System.out.println("Wyniki: "+String.valueOf(times));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MvcResult clearAndFillTableDependingOnId2(Integer id2) throws Exception {
        MvcResult mvcResult = null;
        deleteFromIdToId(mvcResult, delete("/study/insurance/deleteAllInsurances"));
        saveInsurancesDependingOnId2(id2);
        return mvcResult;
    }


    private void deleteInsurancesFixedQuantity(Integer id1, Integer id2) {
        try {
            MvcResult mvcResult = null;
            List<Long> times = new ArrayList<>();
            for(int i=0; i<50; i++){
                saveInsurancesDependingOnId2(id2);
                long start1 = System.currentTimeMillis();
                mvcResult = deleteFromIdToId(mvcResult, delete("/study/insurance/deleteInsurances/"+id1+"/"+id2));
                long end1 = System.currentTimeMillis();
                long result = end1 - start1;
                times.add(result);
                assertEquals(mvcResult.getResponse().getStatus(), 200);
            }
            System.out.println("Elapsed Time in milli seconds: " + times);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveInsurancesDependingOnId2(Integer id2) throws Exception {
        String json = new ObjectMapper().writeValueAsString(generateDefinedAmount(id2));
        saveInsurances(json);
    }

    private MvcResult deleteFromIdToId(MvcResult mvcResult, MockHttpServletRequestBuilder delete) throws Exception {
        mvcResult = mockMvc.perform(delete
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return mvcResult;
    }
}