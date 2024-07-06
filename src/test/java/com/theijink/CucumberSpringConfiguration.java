package com.theijink;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = App.class)  // Update this to the correct configuration class
public class CucumberSpringConfiguration {
}