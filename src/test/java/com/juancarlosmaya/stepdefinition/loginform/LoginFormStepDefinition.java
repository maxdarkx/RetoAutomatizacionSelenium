package com.juancarlosmaya.stepdefinition.loginform;

import com.github.javafaker.Faker;
import com.juancarlosmaya.model.loginform.LoginFormModel;
import com.juancarlosmaya.page.loginform.LoginFormPage;
import com.juancarlosmaya.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginFormStepDefinition extends WebUI {
    private static final Logger LOGGER  = Logger.getLogger(LoginFormStepDefinition.class);
    private LoginFormModel loginFormModel;
    private LoginFormPage loginFormPage;

    private String forLoginSumittedForm()
    {
        return "Accounts Overview";
    }

    private String forLoginSubmittedError()
    {
        return "The username and password could not be verified.";
    }

    private Boolean isExplicitTime = true;
    private int explicitTime = 10;

    @Given("que el usuario desea ingresar a su cuenta")
    public void que_el_usuario_desea_ingresar_a_su_cuenta() {
        try {
            Faker faker = new Faker();
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            loginFormModel = new LoginFormModel();
            loginFormModel.setLogin("Dwana.maya");
            loginFormModel.setPassword("1234567");
            LOGGER.info ("SCENARIO : El usuario ingresa en el sistema un nombre de usuario y contrasena validos");
            LOGGER.info("GIVEN: que el usuario desea ingresar a su cuenta "+
                    loginFormModel.getLogin()+", "+
                    loginFormModel.getPassword()+", ");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma un nombre de usuario y contrasena validos")
    public void el_usuario_ingresa_en_la_plataforma_un_nombre_de_usuario_y_contrasena_validos() {
        try {
            loginFormPage = new LoginFormPage(driver,explicitTime,isExplicitTime,loginFormModel);
            if(isExplicitTime) {
                loginFormPage.withExplicitWaitFillLoginFormModel();
            }
            else {
                loginFormPage.fillLoginFormModel();
            }
            LOGGER.info("WHEN: el usuario ingresa en la plataforma un nombre de usuario y contrasena validos");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }


    @Then("se muestra el resumen de la cuenta")
    public void se_muestra_el_resumen_de_la_cuenta() {
        String result = Boolean.toString(forLoginSumittedForm().equals(loginFormPage.isLoginFormDone()));
        LOGGER.info("THEN: Resultado = " + result + " " + forLoginSumittedForm() + " | " + loginFormPage.isLoginFormDone());
        Assertions.assertEquals(forLoginSumittedForm(), loginFormPage.isLoginFormDone());
        quitDriver();
    }


    @Given("que el usuario desea ingresar a su cuenta pero olvido su password")
    public void que_el_usuario_desea_ingresar_a_su_cuenta_pero_olvido_su_password() {
        try {
            Faker faker = new Faker();
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            loginFormModel = new LoginFormModel();
            loginFormModel.setLogin("Dwana.maya");
            loginFormModel.setPassword("1234");
            LOGGER.info ("SCENARIO : El usuario ingresa en el sistema un nombre de usuario valido pero contrasena invalida");
            LOGGER.info("GIVEN: que el usuario desea ingresar a su cuenta pero olvido su password"+
                    loginFormModel.getLogin()+", "+
                    loginFormModel.getPassword()+", ");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }
    @When("el usuario ingresa en la plataforma un nombre de usuario validos pero escribe mal su contrasena")
    public void el_usuario_ingresa_en_la_plataforma_un_nombre_de_usuario_validos_pero_escribe_mal_su_contrasena() {
        try {
            loginFormPage = new LoginFormPage(driver,explicitTime,isExplicitTime,loginFormModel);
            if(isExplicitTime) {
                loginFormPage.withExplicitWaitFillLoginFormModel();
            }
            else {
                loginFormPage.fillLoginFormModel();
            }
            LOGGER.info("WHEN: el usuario ingresa en la plataforma un nombre de usuario validos pero escribe mal su contrasena");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }
    @Then("se muestra un mensaje de error indicando que la contrasena es erronea")
    public void se_muestra_un_mensaje_de_error_indicando_que_la_contrasena_es_erronea() {
        String result = Boolean.toString(forLoginSubmittedError().equals(loginFormPage.isLoginFormError()));
        LOGGER.info("THEN: Resultado = " + result + " " + forLoginSubmittedError() + " | " + loginFormPage.isLoginFormError());
        Assertions.assertEquals(forLoginSubmittedError(), loginFormPage.isLoginFormError());
        quitDriver();
    }
}
