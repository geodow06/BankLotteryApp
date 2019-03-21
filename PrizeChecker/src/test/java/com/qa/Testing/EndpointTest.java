package com.qa.Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.PrizeChecker.PrizeCheckerApplication;
import com.qa.PrizeChecker.Rest.PrizeCheckerEndpoint;
import com.qa.PrizeChecker.Service.PrizeCheckerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PrizeCheckerApplication.class)
public class EndpointTest {
	
	@InjectMocks
	private PrizeCheckerEndpoint end;
	
	@Mock
	private PrizeCheckerService src;
	
	@Test
	public void test1() {
		end = new PrizeCheckerEndpoint(src);
		Mockito.when(src.checkWinner(Mockito.anyString())).thenReturn("$0");
		assertEquals("$0", end.checkWinner("a000000"));
	}

}
