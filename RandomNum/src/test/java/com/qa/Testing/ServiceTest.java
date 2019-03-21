package com.qa.Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.RandomNum.Service.RandomNum10;
import com.qa.RandomNum.Service.RandomNum6;
import com.qa.RandomNum.Service.RandomNum8;
import com.qa.RandomNum.Service.RandomNumInterface;

public class ServiceTest {
	
	RandomNumInterface src;
	
	@Test
	public void test1() {
		src = new RandomNum6();
		assertEquals(7, src.randomNum().length());
	}
	
	@Test
	public void test2() {
		src = new RandomNum8();
		assertEquals(9, src.randomNum().length());
	}
	
	@Test
	public void test3() {
		src = new RandomNum10();
		assertEquals(11, src.randomNum().length());
	}
}
