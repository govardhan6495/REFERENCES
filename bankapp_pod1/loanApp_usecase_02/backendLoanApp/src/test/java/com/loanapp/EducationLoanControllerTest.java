package com.loanapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
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
import com.loanapp.controller.EducationLoanController;
import com.loanapp.model.EducationLoan;
import com.loanapp.service.EducationLoanService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EducationLoanController.class)
public class EducationLoanControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	
	@MockBean
	private EducationLoanService eduLoanService;
	
	@Test
	public void testApplyEduLoan() throws Exception {
	
		EducationLoan mockEduLoan = new EducationLoan();
		mockEduLoan.setEloanId(36);
		mockEduLoan.setCname("M.Tech");
		mockEduLoan.setCfee(300000);
		mockEduLoan.setFname("Chethan Nair");
		mockEduLoan.setFtotexp(23);
		mockEduLoan.setFocup("Publisher");
		mockEduLoan.setFcurexp(18);
		mockEduLoan.setRtcno("ERGHF16497");
		mockEduLoan.setAninc(2300000);

		
		String inputInJson = this.mapToJson(mockEduLoan);
		String URI = "/eloan/v1/apply";
		
		Mockito.when(eduLoanService.applyEduLaon(Mockito.any(EducationLoan.class))).thenReturn(mockEduLoan);
		
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
