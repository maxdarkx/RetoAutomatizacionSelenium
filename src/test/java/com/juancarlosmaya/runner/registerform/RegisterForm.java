package com.juancarlosmaya.runner.registerform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/registerform/register.feature"},
        glue = "com.juancarlosmaya.stepdefinition.registerform.RegisterFormStepDefinition",
        tags = "@Regresion"

)


public class RegisterForm {
}
