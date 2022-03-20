package com.juancarlosmaya.stepdefinition.registerform;

import com.juancarlosmaya.model.registerform.RegisterFormModel;
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
    private static final Logger LOGGER = Logger.getLogger(RegisterFormStepDefinition.class);
    private RegisterFormModel registerFormModel;
    private RegisterFormPage registerFormPage;
    private RegisterFormUser registerFormUser;

    @Given("que el usuario desea ingresar a la plataforma")
    public void que_el_usuario_desea_ingresar_a_la_plataforma() {
        try {
            registerFormUser = new RegisterFormUser();
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            registerFormModel = new RegisterFormModel();
            registerFormModel.setFirstName(registerFormUser.getFirstName());
            registerFormModel.setLastName(registerFormUser.getLastName());
            registerFormModel.setAddress(registerFormUser.getAddress());
            registerFormModel.setCity(registerFormUser.getCity());
            registerFormModel.setState(registerFormUser.getState());
            registerFormModel.setPhone(registerFormUser.getPhone());
            registerFormModel.setSsn(registerFormUser.getSsn());
            registerFormModel.setZip(registerFormUser.getZip());
            registerFormModel.setUser(registerFormUser.getUser());
            registerFormModel.setPassword(registerFormUser.getPassword());
            LOGGER.info ("SCENARIO : El usuario ingresa en el sistema todos sus datos personales validos");
            LOGGER.info("GIVEN: Se envia correctamente el usuario "+registerFormUser.getFirstName()+", "+
                    registerFormUser.getLastName()+", "+
                    registerFormUser.getAddress()+", "+
                    registerFormUser.getCity()+", "+
                    registerFormUser.getState()+", "+
                    registerFormUser.getPhone()+", "+
                    registerFormUser.getSsn()+", "+
                    registerFormUser.getZip()+", "+
                    registerFormUser.getUser()+", "+
                    registerFormUser.getPassword());
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
            LOGGER.info("WHEN: Se recibe el usuario");
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
        String result = Boolean.toString(forRegiserFormDone().equals(registerFormPage.isRegisterFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forRegiserFormDone()+" | "+registerFormPage.isRegisterFormDone());
        Assertions.assertEquals(forRegiserFormDone(), registerFormPage.isRegisterFormDone());
        quitDriver();
    }


    private List<String> forRegiserFormDone()
    {
        List<String> submittedRegisterFormResult = new ArrayList<>();
        submittedRegisterFormResult.add("Welcome " + registerFormModel.getUser());
        submittedRegisterFormResult.add("Your account was created successfully. You are now logged in.");
        return submittedRegisterFormResult;
    }
}