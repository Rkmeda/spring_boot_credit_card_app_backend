package com.ps.cc.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ps.cc.application.service.CreditCardApplicationService;

@ActiveProfiles("test")
@TestConfiguration
public class CreditCardControllerTest extends ApplicationTests{
	
	@Mock
	CreditCardApplicationService creditCardApplicationService;
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testAddNewCard() throws Exception {

		String record = "{\"statusMsg\":\"SUCCESS\",\"statusCode\":\"412\",\"data\":[{\"id\":1,\"name\":\"Ramakrishna\",\"cardNumber\":\"6304219447607087665\",\"balance\":\"100000\",\"limit\":\"500000\"}]}";;

		String mockAdd = "{\r\n" + "    \"name\":\"Ramakrishna\",\r\n"
				+ "    \"cardNumber\":\"6304219447607087665\",\r\n" + "    \"balance\": \"100000\",\r\n"
				+ "    \"limit\":\"500000\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard/v1/addNewCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record, resultCZ);
	}
	
	@Test
	public void testAddNewCard_invalidCard() throws Exception {

		String record = "{\"errorCode\":\"411\",\"errorMsg\":\"This is not a valid card\"}";

		String mockAdd = "{\r\n" + "    \"name\":\"Ramakrishna\",\r\n" + "    \"cardNumber\":\"1234\",\r\n"
				+ "    \"balance\": \"100000\",\r\n" + "    \"limit\":\"500000\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard/v1/addNewCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record.toString(), resultCZ);
	}

	@Test
	public void testAddNewCard_greaterThan19() throws Exception {

		String record = "{\"errorCode\":\"411\",\"errorMsg\":\"This is not a valid card\"}";

		String mockAdd = "{\r\n" + "    \"name\":\"Ramakrishna\",\r\n"
				+ "    \"cardNumber\":\"63042194476070876655\",\r\n" + "    \"balance\": \"500000\",\r\n"
				+ "    \"limit\":\"4546544\"\r\n" + "}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard/v1/addNewCard")
				.contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
		assertEquals(record.toString(), resultCZ);
	}

}
