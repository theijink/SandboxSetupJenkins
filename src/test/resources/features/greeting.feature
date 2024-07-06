Feature: Greeting

    Scenario: Say hello
        Given the application is running
        When I ask it to say hello
        Then it should reply with "Hello, World!"