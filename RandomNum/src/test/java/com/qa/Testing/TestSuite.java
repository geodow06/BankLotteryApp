package com.qa.Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ EndpointTest.class, ServiceTest.class })

public class TestSuite {
}