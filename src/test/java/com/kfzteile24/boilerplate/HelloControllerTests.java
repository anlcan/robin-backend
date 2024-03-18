package com.kfzteile24.boilerplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kfzteile24.boilerplate.controller.HelloController;
import com.kfzteile24.boilerplate.dto.hello.HelloRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 03.01.24.
 */
@WebMvcTest(HelloController.class)
@AutoConfigureMockMvc
public class HelloControllerTests {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    public void getHelloTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/hello")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").isNotEmpty());
    }

    @Test
    public void postHelloTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/hello")
                        .content(mapper.writeValueAsString(new HelloRequest("www-k24-de")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(BigDecimal.TEN));
    }
}
