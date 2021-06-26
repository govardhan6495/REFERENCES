package com.cts.bankapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cts.bankapp.model.User;
import com.cts.bankapp.repository.UserRepository;
import com.cts.bankapp.request.LoginRequest;
import com.cts.bankapp.request.RegisterRequest;
import com.cts.bankapp.security.jwt.TokenGeneratorUtil;


@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;

	 @Mock
	 @Autowired
	 private UserRepository repo;

	private UserController userController;

	@Mock
	PasswordEncoder encoder;
	@MockBean
	User user;
	   static final long EXPIRATIONTIME = 864_000_000; 
	    static final String SECRET = "secretKey";
	    static final String TOKEN_PREFIX = "Bearer";
	    static final String HEADER_STRING = "Authorization";

	@Before
	public void setUp() throws Exception {

		userController = mock(UserController.class);
		repo=mock(UserRepository.class);

		    
	}

	//@Test
	public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
		mockMvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	//@Test
	public void authenticateUserForlogin() throws Exception {
		Authentication authToken = new UsernamePasswordAuthenticationToken("ABCD", "test");
		SecurityContextHolder.getContext().setAuthentication(authToken);
		   String token = TokenGeneratorUtil.generateJwtToken(authToken);
		   assertNotNull(token);
		   mockMvc.perform(MockMvcRequestBuilders.post("/login").header("Authorization", token)).andExpect(status().isOk());
		   
		   LoginRequest request=new LoginRequest();
		   request.setUsername("ABCD");
		   request.setPassword("test");
		   userController.login(request);
		   
	}
	//@Test
	public void registerUser() throws Exception {
		Authentication authToken = new UsernamePasswordAuthenticationToken("ABCD", "test");
		SecurityContextHolder.getContext().setAuthentication(authToken);
		   String token = TokenGeneratorUtil.generateJwtToken(authToken);
		RegisterRequest registerRequest=new RegisterRequest();
		registerRequest.setUsername("test");
		registerRequest.setPassword("password");
		User user=new User();
		user.setUsername("test");
		user.setPassword("password");
		doReturn(true).when(repo.existsByUsername("test"));
		repo.save(user);
		RequestBuilder request1=MockMvcRequestBuilders.post("/api/auth/register").accept((MediaType.APPLICATION_JSON)).content(token).contentType(MediaType.APPLICATION_JSON);
		   MvcResult result=(MvcResult) mockMvc.perform(request1).andReturn();
		  assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		  userController.register(registerRequest);
		
	}
	// @Test
	    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.post("/login")).andExpect(status().isForbidden());
	    }
	    
	   

	  

}
