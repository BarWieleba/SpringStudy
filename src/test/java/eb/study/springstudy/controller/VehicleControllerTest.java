package eb.study.springstudy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.dto.VehicleDto;
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
class VehicleControllerTest {

    private Logger log = LoggerFactory.getLogger(VehicleControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private VehicleController vehicleController;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }

    private List<VehicleDto> generate(){
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehicleDtos.add(VehicleDto.builder().id(1L).brand("Volkswagen").model("Golf").build());
        vehicleDtos.add(VehicleDto.builder().id(2L).brand("Volkswagen").model("Golf Plus").build());
        vehicleDtos.add(VehicleDto.builder().id(3L).brand("Volkswagen").model("Passat").build());
        vehicleDtos.add(VehicleDto.builder().id(4L).brand("Volkswagen").model("Polo").build());
        vehicleDtos.add(VehicleDto.builder().id(5L).brand("Volkswagen").model("Taigo").build());
        vehicleDtos.add(VehicleDto.builder().id(6L).brand("Volkswagen").model("Tiguan").build());
        vehicleDtos.add(VehicleDto.builder().id(7L).brand("Volkswagen").model("Touran").build());
        vehicleDtos.add(VehicleDto.builder().id(8L).brand("Volkswagen").model("Sharan").build());
        vehicleDtos.add(VehicleDto.builder().id(9L).brand("Volkswagen").model("ID.4").build());
        vehicleDtos.add(VehicleDto.builder().id(10L).brand("Volkswagen").model("ID.3").build());
        return vehicleDtos;
    }

    @Test
    void saveVehicles() {
        try {
            String json = new ObjectMapper().writeValueAsString(generate());
            MvcResult mvcResult = mockMvc.perform(post("/study/vehicles/saveVehicles")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            assertEquals(mvcResult.getResponse().getStatus(), 200);
        } catch (Exception e) {
           log.error(e.getMessage());
        }

    }
}