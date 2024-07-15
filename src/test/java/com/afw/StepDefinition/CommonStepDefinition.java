package com.afw.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.afw.Web_Driver_Manager.DriverManager;

public class CommonStepDefinition {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinition.class);
    
    @Before
    public void setUp() {
    	
    	LOGGER.info("Execution Started");
        DriverManager.getDriver();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // Increase as needed
        LOGGER.info("Driver is set up");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        LOGGER.info("Driver is quit");
    }
}