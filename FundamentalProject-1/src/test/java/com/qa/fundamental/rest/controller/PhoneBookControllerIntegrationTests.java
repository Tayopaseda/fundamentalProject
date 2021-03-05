package com.qa.fundamental.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.fundamental.persistence.domain.PhoneBook;
import com.qa.fundamental.persistence.repository.PhoneBookRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@Sql(scripts = { "classpath:schema.sql","classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles(profiles = "test")
public class PhoneBookControllerIntegrationTests {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
    private ObjectMapper mapper;
	
	private final PhoneBook TEST_CONTACT_SAVED1 = new PhoneBook(1L,"johnny","bravo", "12345567", "johnny@bravo.com");
	private final PhoneBook TEST_CONTACT_SAVED2 = new PhoneBook(2L,"buttercup","puffgirl","000000000","buttercup@puff.com");
	private final PhoneBook TEST_CONTACT_SAVED3 = new PhoneBook(3L,"ben","ten","1111111111","ben@ten.com");
	
	private final List<PhoneBook> CONTACTS = new ArrayList<PhoneBook>();
	
	@BeforeAll
	public void setup() throws JsonProcessingException, Exception {
		this.mockMVC
			.perform(post("/phonebook/create").contentType(MediaType.APPLICATION_JSON)
					.content(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)));	
		this.mockMVC
		.perform(post("/phonebook/create").contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(TEST_CONTACT_SAVED2)));	
		this.mockMVC
		.perform(post("/phonebook/create").contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(TEST_CONTACT_SAVED3)));	
		
	}

	@Test
	public void testCreate() throws JsonProcessingException, Exception {
		 this.mockMVC
			.perform(post("/phonebook/create").contentType(MediaType.APPLICATION_JSON)
					.content(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)))
			.andExpect(status().isCreated()).andExpect(content().json(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)));
	}
	
	@Test
	public void testReadById() throws Exception {
		this.mockMVC
		.perform(get("/phonebook/read/id/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)));
	}
	
	
	@Test
	public void testReadAll() throws Exception {
		CONTACTS.add(TEST_CONTACT_SAVED1);
		CONTACTS.add(TEST_CONTACT_SAVED2);
		CONTACTS.add(TEST_CONTACT_SAVED3);
		
		this.mockMVC.perform(get("/phonebook/readAll").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().json(this.mapper
                .writeValueAsString(CONTACTS)));
	}
	
	@Test
	public void testReadByNum() throws Exception {
		this.mockMVC.perform(get("/phonebook/read/phone/12345567")).andExpect(status().isOk())
        .andExpect(content().json(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)));
	}
	
	@Test
	public void testReadByName() throws Exception {
		List<PhoneBook> johnny = new ArrayList<PhoneBook>();
		johnny.add(TEST_CONTACT_SAVED1);

		this.mockMVC.perform(get("/phonebook/read/name/johnny")).andExpect(status().isOk())
        .andExpect(content().json(this.mapper.writeValueAsString(johnny)));
	}
	
	@Test
	public void testReadByEmail() throws Exception {
		this.mockMVC.perform(get("/phonebook/read/email/johnny@bravo.com")).andExpect(status().isOk())
        .andExpect(content().json(this.mapper.writeValueAsString(TEST_CONTACT_SAVED1)));
	}
	
	
	
	
	
}
