package com.qa.Testing.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.Testing.Endpoint.AccountEndpointTest;
import com.qa.Testing.Service.AccountServiceTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ AccountEndpointTest.class, AccountServiceTest.class })

public class TestSuite {
}