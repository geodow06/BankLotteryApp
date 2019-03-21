package com.qa.Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.PrizeChecker.Service.PrizeCheckerService;

public class ServiceTest {
	
	PrizeCheckerService src = new PrizeCheckerService();
	
	@Test
	public void test1() {
		assertEquals("$0", src.checkWinner("a111111"));
		assertEquals("$0", src.checkWinner("a11111111"));
		assertEquals("$0", src.checkWinner("a1111111111"));
	}
	
	@Test
	public void test2() {
		assertEquals("$50", src.checkWinner("b111111"));
	}
	
	@Test
	public void test3() {
		assertEquals("$100", src.checkWinner("c111111"));
	}
	
	@Test
	public void test4() {
		assertEquals("$500", src.checkWinner("b11111111"));
	}
	
	@Test
	public void test5() {
		assertEquals("$750", src.checkWinner("c11111111"));
	}
	
	@Test
	public void test6() {
		assertEquals("$5000", src.checkWinner("b1111111111"));
	}
	
	@Test
	public void test7() {
		assertEquals("$10000", src.checkWinner("c1111111111"));
	}
}
