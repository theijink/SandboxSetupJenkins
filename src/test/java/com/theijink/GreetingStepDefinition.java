package com.theijink;


import org.springframework.beans.factory.annotation.Autowired;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class GreetingStepDefinition {

    @Autowired
    private App app;
    private String greeting;

    @Given("the application is running")
    public void the_application_is_running() {
        // Spring context will inject the App instance
    }

    @When("I ask it to say hello")
    public void i_ask_it_to_say_hello() {
        greeting = app.sayHello();
    }

    @Then("it should reply with {string}") 
    public void it_should_reply_with(String expectedGreeting) {
        assertEquals(expectedGreeting, greeting);
    }
    
    
}
