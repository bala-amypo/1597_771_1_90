package com.example.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestResultListener.class)
public class MasterTestNGSuiteTest {

    @BeforeClass
    public void setUp() {
    }

    @Test
    public void testFrameworkLoads() {
        assert true;
    }

    @Test
    public void testBasePackage() {
        assert DemoApplication.class
                .getPackage()
                .getName()
                .equals("com.example.demo");
    }

    @Test
    public void testDemoServletExists() throws ClassNotFoundException {
        Class.forName("com.example.demo.DemoServlet");
        assert true;
    }
}
