package com.application.customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerIntegrationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser(value = "spring")
    @Test
    public void getAllCustomersTest_StatusOK() throws Exception{
        mockMvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @WithMockUser(value = "spring")
    @Test
    public void getCustomersByIdTest_StatusOK() throws Exception{
        mockMvc.perform(get("/customers/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                {
                                    "id": 1,
                                    "name": "NAMEONE",
                                    "lastname": "LASTNAME",
                                    "status": "ACTIVE"
                                }"""));
    }

    @WithMockUser(value = "spring")
    @Test
    public void getCustomersByStatusActive_StatusOK() throws Exception{
        mockMvc.perform(get("/customers/filter/ACTIVE").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    public void saveCustomer_StatusCREATED() throws Exception{

        this.mockMvc.perform(post("/customers")
                        .with(csrf().asHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\":5, \"name\":\"NAMEFIVE\", \"lastname\":\"LASTNAME\", \"status\": \"ACTIVE\"}"))
                        .andExpect(status().isCreated())
                        .andExpect(content().json("""
                                {
                                    "id": 5,
                                    "name": "NAMEFIVE",
                                    "lastname": "LASTNAME",
                                    "status": "ACTIVE"
                                }"""));
    }



}
