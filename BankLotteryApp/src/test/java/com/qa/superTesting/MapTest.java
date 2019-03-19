package com.qa.superTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.Repository.AccountMapHash;

public class MapTest {
	
	AccountMapHash map;
	
	@Before
	public void setup() {
		map = new AccountMapHash();
	}
	
	@Test
	public void test1() {
		map.addAccount("help", "help");
		map.addAccount("help", "help");
		map.addAccount("help", "help");
		assertEquals(1, map.getHashMap().size());
	}
	
	@Test
	public void test2() {
		map.addAccount("help1", "123");
		map.addAccount("help2", "123");
		map.addAccount("help3", "123");
		assertEquals(3, map.getHashMap().size());
	}
}
