package com.juancarlosmaya.runner.loginform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/loginform/login.feature"},
        glue = "com.juancarlosmaya.stepdefinition.loginform.LoginFormStepDefinition",
        tags = "@Regresion"
)

public class LoginForm {
}
