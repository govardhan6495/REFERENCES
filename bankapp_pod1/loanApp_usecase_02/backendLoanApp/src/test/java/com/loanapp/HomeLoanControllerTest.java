package com.loanapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loanapp.controller.HomeLoanController;
import com.loanapp.model.HomeLoan;
import com.loanapp.service.HomeLoanService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HomeLoanController.class)
public class HomeLoanControllerTest {

	@Autowired
	private MockMvc mockMvc;

	
	@MockBean
	HomeLoanService homeLoanService;
	
	
	@Test
	public void testApplyHomeLoan() throws Exception{
		HomeLoan mockHomeLoan = new HomeLoan();
		
		mockHomeLoan.setHloanId(63);
		mockHomeLoan.setCmpname("Company63");
		mockHomeLoan.setDesgn("Designation64");
		mockHomeLoan.setTotexp(12);
		mockHomeLoan.setCurexp(10);
		mockHomeLoan.setAninc(1600000);
		
		String inputInJson = this.mapToJson(mockHomeLoan);
		String URI = "/hloan/v1/apply";
		
		Mockito.when(homeLoanService.applyHomeLoan(Mockito.any(HomeLoan.class))).thenReturn(mockHomeLoan);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}


}
