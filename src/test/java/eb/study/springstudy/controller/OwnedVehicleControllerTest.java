package eb.study.springstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.OwnedVehicleDto;
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
import java.time.LocalDate;
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

    private List<OwnedVehicleDto> generateDefinedAmount(int amount) {
        List<OwnedVehicleDto> dtos = new ArrayList<>();
        LocalDate localDate = LocalDate.of(2000, 1, 1);

        for(int i = 1; i <=amount; i++) {
            long fkValue = Long.valueOf(i%10 == 0 ? 10 : i%10);
            dtos.add(OwnedVehicleDto.builder().id(Long.valueOf(i)).fkOwnerId(fkValue).fkVehicleId(fkValue).productionDate(Date.valueOf(localDate)).fkBodyStyleId(fkValue).fkColourId(fkValue).build());
            localDate = localDate.plusDays(1);
        }
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
    void save1000OwnedVehicles50Times() throws Exception {
        String json = new ObjectMapper().writeValueAsString(generateDefinedAmount(1000));
        List<Long> savingTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            //saving
            long start = System.currentTimeMillis();
            MvcResult mvcResult = this.mockMvc.perform(post("/study/ownedvehicles/saveOwnedVehicles")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long end = System.currentTimeMillis();
            System.out.println(i + ": Saving Elapsed Time in nano seconds: " + (end - start));
            savingTimes.add(end-start);

            //updating
            long startUpdate = System.currentTimeMillis();
            MvcResult mvcResultUpdate = this.mockMvc.perform(post("/study/ownedvehicles/updateOwnedVehicles/11/11/1/1000")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long endUpdate = System.currentTimeMillis();
            System.out.println("Elapsed Time in nano seconds: " + (endUpdate - startUpdate));
            updateTimes.add(endUpdate - startUpdate);

            //deleting
            long startDelete = System.currentTimeMillis();
            MvcResult mvcResultDelete = this.mockMvc.perform(delete("/study/ownedvehicles/deleteAll"))
                    .andExpect(status().isOk()).andReturn();
            long endDelete = System.currentTimeMillis();
            System.out.println("Deleting Elapsed Time in nano seconds: " + (endDelete - startDelete));
            deletingTimes.add(endDelete-startDelete);

        }
        System.out.println("Save time elapsed: ");
        for(Long time : savingTimes) {
            System.out.println(time);
        }
        System.out.println("Update time elapsed: ");
        for(Long time : updateTimes) {
            System.out.println(time);
        }
        System.out.println("Delete time elapsed: ");
        for(Long time : deletingTimes) {
            System.out.println(time);
        }
        assertEquals(50, savingTimes.size());
    }

    @Test
    void save100wnedVehicles50Times() throws Exception {
        String json = new ObjectMapper().writeValueAsString(generateDefinedAmount(100));
        List<Long> savingTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            //saving
            long start = System.currentTimeMillis();
            MvcResult mvcResult = this.mockMvc.perform(post("/study/ownedvehicles/saveOwnedVehicles")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long end = System.currentTimeMillis();
            System.out.println(i + ": Saving Elapsed Time in nano seconds: " + (end - start));
            savingTimes.add(end-start);

            //updating
            long startUpdate = System.currentTimeMillis();
            MvcResult mvcResultUpdate = this.mockMvc.perform(post("/study/ownedvehicles/updateOwnedVehicles/11/11/1/100")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long endUpdate = System.currentTimeMillis();
            System.out.println("Elapsed Time in nano seconds: " + (endUpdate - startUpdate));
            updateTimes.add(endUpdate - startUpdate);

            //deleting
            long startDelete = System.currentTimeMillis();
            MvcResult mvcResultDelete = this.mockMvc.perform(delete("/study/ownedvehicles/deleteAll"))
                    .andExpect(status().isOk()).andReturn();
            long endDelete = System.currentTimeMillis();
            System.out.println("Deleting Elapsed Time in nano seconds: " + (endDelete - startDelete));
            deletingTimes.add(endDelete-startDelete);

        }
        System.out.println("Save time elapsed: ");
        for(Long time : savingTimes) {
            System.out.println(time);
        }
        System.out.println("Update time elapsed: ");
        for(Long time : updateTimes) {
            System.out.println(time);
        }
        System.out.println("Delete time elapsed: ");
        for(Long time : deletingTimes) {
            System.out.println(time);
        }
        assertEquals(50, savingTimes.size());
    }

    @Test
    void save10000OwnedVehicles50Times() throws Exception {
        String json = new ObjectMapper().writeValueAsString(generateDefinedAmount(10000));
        List<Long> savingTimes = new ArrayList<>();
        List<Long> updatingTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            //saving
            long start = System.currentTimeMillis();
            MvcResult mvcResult = this.mockMvc.perform(post("/study/ownedvehicles/saveOwnedVehicles")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long end = System.currentTimeMillis();
            System.out.println(i + ": Saving Elapsed Time in nano seconds: " + (end - start));
            savingTimes.add(end-start);

            //updating
            long startUpdate = System.currentTimeMillis();
            MvcResult mvcResultUpdate = this.mockMvc.perform(post("/study/ownedvehicles/updateOwnedVehicles/11/11/1/10000")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long endUpdate = System.currentTimeMillis();
            System.out.println("Elapsed Time in nano seconds: " + (endUpdate - startUpdate));
            updatingTimes.add(endUpdate-startUpdate);

            //deleting
            long startDelete = System.currentTimeMillis();
            MvcResult mvcResultDelete = this.mockMvc.perform(delete("/study/ownedvehicles/deleteAll"))
                    .andExpect(status().isOk()).andReturn();
            long endDelete = System.currentTimeMillis();
            System.out.println("Deleting Elapsed Time in nano seconds: " + (endDelete - startDelete));
            deletingTimes.add(endDelete-startDelete);

        }
        System.out.println("Save time elapsed: ");
        for(Long time : savingTimes) {
            System.out.println(time);
        }

        System.out.println("Update time elapsed: ");
        for(Long time : updatingTimes) {
            System.out.println(time);
        }

        System.out.println("Delete time elapsed: ");
        for(Long time : deletingTimes) {
            System.out.println(time);
        }
        assertEquals(50, savingTimes.size());
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

    @Test
    void deleteAllOwnedVehicles() throws Exception {
        long start = System.nanoTime();
        MvcResult mvcResult = this.mockMvc.perform(delete("/study/ownedvehicles/deleteAll"))
                .andExpect(status().isOk()).andReturn();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end - start));
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }
}