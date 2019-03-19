package com.qa.superTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.randomNum.RandomNum10;
import com.qa.randomNum.RandomNum6;
import com.qa.randomNum.RandomNum8;

public class GeneratorTest {
	
	@Test
	public void test6() {
		RandomNum6 generator = new RandomNum6();
		System.out.println(generator.randomNum());
		assertEquals(7, generator.randomNum().length());
	}
	
	@Test
	public void test8() {
		RandomNum8 generator = new RandomNum8();
		System.out.println(generator.randomNum());
		assertEquals(9, generator.randomNum().length());
	}
	
	@Test
	public void test10() {
		RandomNum10 generator = new RandomNum10();
		System.out.println(generator.randomNum());
		assertEquals(11, generator.randomNum().length());
	}

}
