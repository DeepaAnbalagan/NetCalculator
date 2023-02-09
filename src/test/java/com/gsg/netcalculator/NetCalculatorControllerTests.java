package com.gsg.netcalculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NetCalculatorControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getNetValueTest() throws Exception{
        NetModel input = new NetModel(100.0, "DE");
        System.out.println(mockMvc);
        ResultActions response = mockMvc.perform(get("/get/netvalue")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)));
        response.andDo(print()).
                andExpect(status().is2xxSuccessful()).equals("81.0");

    }
    @Test
    public void getNetValueTest_NS() throws Exception{
        NetModel input = new NetModel(100.0, "SE");
        System.out.println(mockMvc);
        ResultActions response = mockMvc.perform(get("/get/netvalue")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)));
        response.andDo(print()).
                andExpect(status().is2xxSuccessful()).equals("Country is not supported");

    }
}
