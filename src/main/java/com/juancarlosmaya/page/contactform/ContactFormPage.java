package com.juancarlosmaya.page.contactform;

import com.juancarlosmaya.model.contactform.ContactFormModel;
import com.juancarlosmaya.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class ContactFormPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(ContactFormPage.class);
    private ContactFormModel contactFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo";

    // for web page inicialization

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"headerPanel\"]/ul[2]/li[3]/a")
    private WebElement contactUs;

    //for inputs
    @CacheLookup
    @FindBy(id = "name")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement phone;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement message;

    @CacheLookup
    @FindBy(xpath = "//form[@id='contactForm']/table/tbody/tr[5]/td[2]/input")
    private WebElement submit;

    //for assertions
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p[1]")
    private WebElement returnCustomer;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p[2]")
    private WebElement returnMessage;

    public ContactFormPage(WebDriver driver, ContactFormModel contactFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.contactFormModel = contactFormModel;
    }

    public ContactFormPage(WebDriver driver, int seconds, boolean explicitTime, ContactFormModel contactFormModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.contactFormModel = contactFormModel;
    }

    public void fillContactFormModel() throws InterruptedException
    {
        scrollOn(contactUs);
        clickOn(contactUs);

        scrollOn(name);
        typeOn(name, contactFormModel.getName());

        scrollOn(email);
        typeOn(email, contactFormModel.getEmail());

        scrollOn(phone);
        typeOn(phone, contactFormModel.getPhone());

        scrollOn(message);
        typeOn(message, contactFormModel.getMessage());

        doSubmit(submit);
    }

    public String isContactFormDone(){
        String submittedContactResult = getText(returnCustomer).trim()+" ";
        submittedContactResult = submittedContactResult.concat(getText(returnMessage).trim());
        return submittedContactResult;
    }
}

