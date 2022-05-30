package eb.study.springstudy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eb.study.springstudy.entity.Colour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class ColourControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ColourController colourController;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(colourController).build();
    }

    public List<Colour> generate() {
        List<Colour> lista = new ArrayList<>();
        lista.add(Colour.builder().id(1L).carColour("żółty").build());
        lista.add(Colour.builder().id(2L).carColour("niebieski").build());
        lista.add(Colour.builder().id(3L).carColour("zielony").build());
        lista.add(Colour.builder().id(4L).carColour("fioletowy").build());
        lista.add(Colour.builder().id(5L).carColour("biały").build());
        lista.add(Colour.builder().id(6L).carColour("czarny").build());
        lista.add(Colour.builder().id(7L).carColour("czerwony").build());
        lista.add(Colour.builder().id(8L).carColour("różowy").build());
        lista.add(Colour.builder().id(9L).carColour("srebry").build());
        lista.add(Colour.builder().id(10L).carColour("złoty").build());
        return lista;
    }

    public String mapper() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(generate());
    }

    @Test
    void saveColours() throws Exception {
        try {
            String json = mapper();
            MvcResult mvcResult = null;
            int i = 1;
            long start1 = System.nanoTime();
            mvcResult = mvc.perform(post("/study/colour/saveColours")
                            .contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk()).andReturn();
            long end1 = System.nanoTime();
            System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));
            assertEquals(mvcResult.getResponse().getStatus(), 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}