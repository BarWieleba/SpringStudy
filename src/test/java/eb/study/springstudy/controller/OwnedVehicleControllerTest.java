package eb.study.springstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.OwnedVehicleDto;
import eb.study.springstudy.entity.OwnedVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OwnedVehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnedVehicleController ownedVehicleController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownedVehicleController).build();
    }

    private List<OwnedVehicleDto> generate() {
        List<OwnedVehicleDto> dtos = new ArrayList<>();
        dtos.add(OwnedVehicleDto.builder().id(1L).fkOwnerId(1L).fkVehicleId(1L).productionDate(Date.valueOf("2020-12-12")).fkBodyStyleId(1L).fkColourId(1L).build());
        dtos.add(OwnedVehicleDto.builder().id(2L).fkOwnerId(2L).fkVehicleId(2L).productionDate(Date.valueOf("2019-01-01")).fkBodyStyleId(2L).fkColourId(2L).build());
        dtos.add(OwnedVehicleDto.builder().id(3L).fkOwnerId(3L).fkVehicleId(3L).productionDate(Date.valueOf("2018-02-02")).fkBodyStyleId(3L).fkColourId(3L).build());
        dtos.add(OwnedVehicleDto.builder().id(4L).fkOwnerId(4L).fkVehicleId(4L).productionDate(Date.valueOf("2017-03-03")).fkBodyStyleId(4L).fkColourId(4L).build());
        dtos.add(OwnedVehicleDto.builder().id(5L).fkOwnerId(5L).fkVehicleId(5L).productionDate(Date.valueOf("2016-04-04")).fkBodyStyleId(5L).fkColourId(5L).build());
        dtos.add(OwnedVehicleDto.builder().id(6L).fkOwnerId(6L).fkVehicleId(6L).productionDate(Date.valueOf("2015-05-05")).fkBodyStyleId(6L).fkColourId(6L).build());
        dtos.add(OwnedVehicleDto.builder().id(7L).fkOwnerId(7L).fkVehicleId(7L).productionDate(Date.valueOf("2014-06-06")).fkBodyStyleId(7L).fkColourId(7L).build());
        dtos.add(OwnedVehicleDto.builder().id(8L).fkOwnerId(8L).fkVehicleId(8L).productionDate(Date.valueOf("2013-07-07")).fkBodyStyleId(8L).fkColourId(8L).build());
        dtos.add(OwnedVehicleDto.builder().id(9L).fkOwnerId(9L).fkVehicleId(9L).productionDate(Date.valueOf("2012-08-08")).fkBodyStyleId(9L).fkColourId(9L).build());
        dtos.add(OwnedVehicleDto.builder().id(10L).fkOwnerId(10L).fkVehicleId(10L).productionDate(Date.valueOf("2011-09-09")).fkBodyStyleId(10L).fkColourId(10L).build());
        return dtos;
    }

    @Test
    void saveOwnedVehicles() throws Exception {
        String json = new ObjectMapper().writeValueAsString(generate());

        long start = System.nanoTime();
        MvcResult mvcResult = this.mockMvc.perform(post("/study/ownedvehicles/saveOwnedVehicles")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end - start));
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }

    @Test
    void getOwnedVehicles() {
    }

    @Test
    void updateOwnedVehicle() throws Exception{
        OwnedVehicleDto dtoToUpdate = OwnedVehicleDto.builder().id(1L).fkBodyStyleId(2L).fkColourId(2L).build();
        String json = new ObjectMapper().writeValueAsString(dtoToUpdate);

        long start = System.nanoTime();
        MvcResult mvcResult = this.mockMvc.perform(put("/study/ownedvehicles/updateOwnedVehicle")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end - start));
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }

    @Test
    void deleteOwnedVehicle() throws Exception {
        OwnedVehicleDto dtoToDelete = OwnedVehicleDto.builder().id(2L).build();
        String json = new ObjectMapper().writeValueAsString(dtoToDelete);

        long start = System.nanoTime();
        MvcResult mvcResult = this.mockMvc.perform(delete("/study/ownedvehicles/deleteOwnedVehicle")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end - start));
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }
}