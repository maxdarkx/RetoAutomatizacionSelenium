package com.juancarlosmaya.stepdefinition.registerform;

import com.juancarlosmaya.model.contactform.ContactFormModel;
import com.juancarlosmaya.model.registerform.RegisterFormModel;
import com.juancarlosmaya.page.contactform.ContactFormPage;
import com.juancarlosmaya.page.registerform.RegisterFormPage;
import com.juancarlosmaya.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class RegisterFormStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(RegisterFormPage.class);
    private RegisterFormModel registerFormModel;
    private RegisterFormPage registerFormPage;

    @Given("que el usuario desea ingresar a la plataforma")
    public void que_el_usuario_desea_ingresar_a_la_plataforma() {
        String firstName = "Juan Carlos";
        String lastName = "Maya";
        String address = "calle 111 63 b 45";
        String city = "Medellin";
        String state = "Antioquia";
        String phone = "3012905481";
        String ssn = "1017131955";
        String zip = "0550044";
        String user= "jcarlos.maya1";
        String password = "1234567";


        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            registerFormModel = new RegisterFormModel();
            registerFormModel.setFirstName(firstName);
            registerFormModel.setLastName(lastName);
            registerFormModel.setAddress(address);
            registerFormModel.setCity(city);
            registerFormModel.setState(state);
            registerFormModel.setPhone(phone);
            registerFormModel.setSsn(ssn);
            registerFormModel.setZip(zip);
            registerFormModel.setUser(user);
            registerFormModel.setPassword(password);
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma su nombre, su apellido, su direccion, su ciudad de residencia, su Departamento su codigo zip, su numero de telefono, su identificacion y un nombre de usuario y contraseña")
    public void el_usuario_ingresa_en_la_plataforma_su_nombre_su_apellido_su_direccion_su_ciudad_de_residencia_su_departamento_su_codigo_zip_su_numero_de_telefono_su_identificacion_y_un_nombre_de_usuario_y_contraseña() {
        try {
            registerFormPage = new RegisterFormPage(driver,10,true,registerFormModel);
            registerFormPage.fillRegisterFormModel();
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Then("se creara un nombre de usuario valido para que el usuario utilice la plataforma")
    public void se_creara_un_nombre_de_usuario_valido_para_que_el_usuario_utilice_la_plataforma() {
        Assertions.assertEquals(forRegiserFormDone(), registerFormPage.isRegisterFormDone());
        quitDriver();
    }


    private List<String> forRegiserFormDone()
    {
        List<String> submittedRegisterFormResult = new ArrayList<String>();
        submittedRegisterFormResult.add("Welcome " + registerFormModel.getUser());
        submittedRegisterFormResult.add("Your account was created successfully. You are now logged in.");
        return submittedRegisterFormResult;
    }
}