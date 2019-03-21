package com.qa.Testing.Service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.Lottery.LotteryApplication;
import com.qa.Lottery.Domain.Account;
import com.qa.Lottery.Repository.AccountRepo;
import com.qa.Lottery.Service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LotteryApplication.class)
public class AccountServiceTest {
	
	@InjectMocks
	private AccountService src;
	
	@Mock
	private AccountRepo repo;
	
	private static final Account MOCK_OBJ1 = new Account("Send");
	private static final Account MOCK_OBJ2 = new Account("Help");
	private static final List<Account> MOCK_LIST = new ArrayList<Account>();

	@Before
	public void setup() {
		src = new AccountService(repo);
		MOCK_LIST.add(MOCK_OBJ1);
		MOCK_LIST.add(MOCK_OBJ2);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(this.repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, src.getAllAccounts());
	}
	
	@Test
	public void testGetOne() {
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(Optional.of(MOCK_OBJ1));
		assertEquals(MOCK_OBJ1, src.getAccountById(1L));
	}
	
	@Test
	public void testCreateAccount() {
		MOCK_OBJ1.setId(1L);
		Mockito.when(this.repo.save(Mockito.any())).thenReturn(MOCK_OBJ1);
		assertEquals((Long) 1L, src.createAccount(MOCK_OBJ1));
	}
	
	@Test
	public void testRemoveOne() {
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(true);
		assertEquals(true, src.removeAccount(1L));
	}
	
	@Test
	public void testRemoveAll() {
		Mockito.when(this.repo.count()).thenReturn(0L);
		assertEquals(true, src.removeAll());
	}
	
	@Test
	public void testUpdate1() {
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(this.repo.getOne(Mockito.anyLong())).thenReturn(MOCK_OBJ1);
		assertEquals("Done", src.updateAccount(MOCK_OBJ2, 1L));
	}
	
	@Test
	public void testUpdate2() {
		MOCK_OBJ2.setAccountId("c111111");
		MOCK_OBJ2.setName(null);
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(this.repo.getOne(Mockito.anyLong())).thenReturn(MOCK_OBJ1);
		assertEquals("Done", src.updateAccount(MOCK_OBJ2, 1L));
	}
	
	@Test
	public void testUpdate3() {
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(false);
		assertEquals("No such account", src.updateAccount(MOCK_OBJ2, 1L));
	}
}
