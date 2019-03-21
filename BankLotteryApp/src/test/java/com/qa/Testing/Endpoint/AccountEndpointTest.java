package com.qa.Testing.Endpoint;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.qa.Lottery.LotteryApplication;
import com.qa.Lottery.Domain.Account;
import com.qa.Lottery.Rest.AccountEndpoint;
import com.qa.Lottery.Service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LotteryApplication.class)
public class AccountEndpointTest {

	@InjectMocks
	private AccountEndpoint end;
	
	@Mock
	private AccountService src;
	
	@Mock
	private RestTemplate rest;
	
	private static final Account MOCK_OBJ1 = new Account("Send");
	private static final Account MOCK_OBJ2 = new Account("Help");
	private static final List<Account> MOCK_LIST = new ArrayList<Account>();
	private static final String MOCK_URL = "http://localhost:8082/checkWinner/";
	private static final ResponseEntity<String> MOCK_BODY_RESPONSE = new ResponseEntity<>("$100",  HttpStatus.OK);
	
	@Before
	public void setup() {
		end = new AccountEndpoint(src, rest);
		MOCK_LIST.add(MOCK_OBJ1);
		MOCK_LIST.add(MOCK_OBJ2);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(this.src.getAllAccounts()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, end.getAllAccounts());
	}
	
	@Test
	public void testGetOne() {
		Mockito.when(this.src.getAccountById(Mockito.anyLong())).thenReturn(MOCK_OBJ1);
		assertEquals(MOCK_OBJ1, end.getAccountById(1L));
	}
	
	@Test
	public void testRemoveOne() {
		Mockito.when(this.src.removeAccount(Mockito.anyLong())).thenReturn(true);
		assertEquals(true, end.removeAccount(1L));
	}
	
	@Test
	public void testRemoveAll() {
		Mockito.when(this.src.removeAll()).thenReturn(true);
		assertEquals(true, end.removeAll());
	}
	
	@Test
	public void testUpdate() {
		Mockito.when(this.src.updateAccount(Mockito.any(), Mockito.anyLong())).thenReturn("Done");
		assertEquals("Done", end.updateAccount(MOCK_OBJ1, 1L));
	}
	
	@Test
	public void testCheckWinner() {
		MOCK_OBJ1.setAccountId("c111111");
		Mockito.when(this.src.getAccountById(Mockito.anyLong())).thenReturn(MOCK_OBJ1);
		System.out.println(MOCK_OBJ1.getAccountId());
		Mockito.when(this.rest.exchange(MOCK_URL + "c111111", HttpMethod.POST, null, String.class)).thenReturn(MOCK_BODY_RESPONSE);
		assertEquals(MOCK_BODY_RESPONSE.getBody(), end.checkWinner(1L));
	}
	
}
