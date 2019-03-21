//package com.qa.Testing.Endpoint;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.client.RestTemplate;
//
//import com.qa.Lottery.Domain.Account;
//import com.qa.Lottery.Rest.AccountEndpoint;
//import com.qa.Lottery.Service.AccountService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(AccountEndpoint.class)
//@AutoConfigureMockMvc
//public class AccountCreateTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private AccountService src;
//	
//	@MockBean
//	private RestTemplate rest;
//	
//	private static final Account MOCK_OBJ1 = new Account("Send");
//	private static final Account MOCK_OBJ2 = new Account("Help");
//	private static final List<Account> MOCK_LIST = new ArrayList<Account>();
//	
//	@Before
//	public void setup() {
//		MOCK_LIST.add(MOCK_OBJ1);
//		MOCK_LIST.add(MOCK_OBJ2);
//	}
//	
//	@Test
//	public void testCreateAccount() {
//		Mockito.when(src.createAccount(MOCK_OBJ1)).thenReturn(1L);
//		mockMvc.perform(get("http://localhost:8081/getNumber")).andExpect(matcher)
//	}
//	
//
//}
