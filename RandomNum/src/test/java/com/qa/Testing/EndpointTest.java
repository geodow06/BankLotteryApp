package com.qa.Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.RandomNum.RandomNumApplication;
import com.qa.RandomNum.Rest.RandomNumEndpoint;
import com.qa.RandomNum.Service.RandomNumInterface;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RandomNumApplication.class)
public class EndpointTest {
	
	@InjectMocks
	private RandomNumEndpoint end;
	
	@Mock
	private RandomNumInterface src;
	
	@Test
	public void test1() {
		end = new RandomNumEndpoint(src);
		Mockito.when(src.randomNum()).thenReturn("a000000");
		assertEquals("a000000", end.getNumber());
	}

}
