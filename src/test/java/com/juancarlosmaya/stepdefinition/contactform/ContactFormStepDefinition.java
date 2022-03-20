package com.juancarlosmaya.stepdefinition.contactform;

import com.juancarlosmaya.model.contactform.ContactFormModel;
import com.juancarlosmaya.page.contactform.ContactFormPage;
import com.juancarlosmaya.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class ContactFormStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ContactFormStepDefinition.class);
    private ContactFormModel contactFormModel;
    private ContactFormPage contactFormPage;

    private String forContactSubmittedForm(){
        String submitedFormResult = "Thank you "+contactFormModel.getName()+" ";
        return submitedFormResult.concat("A Customer Care Representative will be contacting you.");
    }


    //escenario feliz
    @Given("que el usuario desea enviar un mensaje")
    public void que_el_usuario_desea_enviar_un_mensaje() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Jose Martinez");
            contactFormModel.setEmail("jose.m@wetmail.com");
            contactFormModel.setPhone("3012905482");
            contactFormModel.setMessage("Please block my account");

            LOGGER.info ("SCENARIO : El usuario ingresa en el sistema un nombre, telefono, email y mensaje validos");
            LOGGER.info("GIVEN: que el usuario desea enviar un mensaje "+contactFormModel.getName()+", "+
                    contactFormModel.getEmail()+", "+
                    contactFormModel.getPhone()+", "+
                    contactFormModel.getMessage()+", ");

        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma un nombre, telefono, email y mensaje validos")
    public void el_usuario_ingresa_en_la_plataforma_un_nombre_telefono_email_y_mensaje_validos() {
        try {
            contactFormPage = new ContactFormPage(driver,10,true,contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: Se reciben los datos de contacto del usuario");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Then("se muestra el mensaje de contacto")
    public void se_muestra_el_mensaje_de_contacto() {
        String result = Boolean.toString(forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertEquals(forContactSubmittedForm(),contactFormPage.isContactFormDone());
        quitDriver();
    }



    //escenario email invalido
    @Given("que el usuario desea enviar un mensaje pero no desea ingresar su email")
    public void que_el_usuario_desea_enviar_un_mensaje_pero_no_desea_ingresar_su_email() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Jose Martinez");
            contactFormModel.setEmail("jose.m");
            contactFormModel.setPhone("3012905482");
            contactFormModel.setMessage("Please block my account");

            LOGGER.info ("SCENARIO : que el usuario desea enviar un mensaje pero no desea ingresar su email");
            LOGGER.info("GIVEN: que el usuario desea enviar un mensaje "+contactFormModel.getName()+", "+
                    contactFormModel.getEmail()+", "+
                    contactFormModel.getPhone()+", "+
                    contactFormModel.getMessage()+", ");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma un nombre, telefono y mensaje validos, y un email invalido")
    public void el_usuario_ingresa_en_la_plataforma_un_nombre_telefono_y_mensaje_validos_y_un_email_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver,10,true,contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: Se reciben los datos de contacto del usuario");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Then("se muestra un mensaje de error")
    public void se_muestra_un_mensaje_de_error() {
        String result = Boolean.toString(!forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(),contactFormPage.isContactFormDone());
        quitDriver();
    }

    //escenario Telefono solo texto
    @Given("que el usuario desea enviar un mensaje pero no desea ingresar su telefono")
    public void que_el_usuario_desea_enviar_un_mensaje_pero_no_desea_ingresar_su_telefono() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Jose Martinez");
            contactFormModel.setEmail("jose.m@wetmail.com");
            contactFormModel.setPhone("holaMundo");
            contactFormModel.setMessage("Please block my account");

            LOGGER.info ("SCENARIO : que el usuario desea enviar un mensaje pero no desea ingresar su telefono");
            LOGGER.info("GIVEN: que el usuario desea enviar un mensaje "+contactFormModel.getName()+", "+
                    contactFormModel.getEmail()+", "+
                    contactFormModel.getPhone()+", "+
                    contactFormModel.getMessage()+", ");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma un nombre, email y mensaje validos, y un telefono invalido")
    public void el_usuario_ingresa_en_la_plataforma_un_nombre_email_y_mensaje_validos_y_un_telefono_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver,10,true,contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: Se reciben los datos de contacto del usuario");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Then("se muestra un mensaje indicando telefono erroneo")
    public void se_muestra_un_mensaje_indicando_telefono_erroneo() {
        String result = Boolean.toString(!forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(),contactFormPage.isContactFormDone());
        quitDriver();
    }

    //nombre invalido
    @Given("que el usuario desea enviar un mensaje pero no desea ingresar su nombre")
    public void que_el_usuario_desea_enviar_un_mensaje_pero_no_desea_ingresar_su_nombre() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("_____");
            contactFormModel.setEmail("jose.m@wetmail.com");
            contactFormModel.setPhone("3012905482");
            contactFormModel.setMessage("Please block my account");

            LOGGER.info ("SCENARIO : que el usuario desea enviar un mensaje pero no desea ingresar su nombre");
            LOGGER.info("GIVEN: que el usuario desea enviar un mensaje "+contactFormModel.getName()+", "+
                    contactFormModel.getEmail()+", "+
                    contactFormModel.getPhone()+", "+
                    contactFormModel.getMessage()+", ");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @When("el usuario ingresa en la plataforma un telefono, email y mensaje validos, y un nombre invalido")
    public void el_usuario_ingresa_en_la_plataforma_un_telefono_email_y_mensaje_validos_y_un_nombre_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver,10,true,contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: Se reciben los datos de contacto del usuario");
        }
        catch (Exception e)
        {
            quitDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Then("se muestra un mensaje indicando nombre erroneo")
    public void se_muestra_un_mensaje_indicando_nombre_erroneo() {
        String result = Boolean.toString(!forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(),contactFormPage.isContactFormDone());
        quitDriver();
    }
}