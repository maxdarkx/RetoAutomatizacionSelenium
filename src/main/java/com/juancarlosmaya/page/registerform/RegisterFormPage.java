package com.juancarlosmaya.page.registerform;

import com.juancarlosmaya.model.registerform.RegisterFormModel;
import com.juancarlosmaya.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RegisterFormPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(RegisterFormPage.class);
    private RegisterFormModel registerFormModel;



    // for web page inicialization
    @CacheLookup
    @FindBy(xpath ="//div[@id='loginPanel']/p[2]/a")
    private WebElement registerLinkPage;

    @CacheLookup
    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPassword;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement register;

    //for assertions

    //Welcome "userName"
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
    private WebElement welcomeUser;

    //Your account was created successfully. You are now logged in.
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement welcomeMessage;


    public RegisterFormPage(WebDriver driver, RegisterFormModel registerFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.registerFormModel = registerFormModel;
    }

    public RegisterFormPage(WebDriver driver, int seconds, boolean explicitTime, RegisterFormModel registerFormModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.registerFormModel = registerFormModel;
    }

    public void fillRegisterFormModel() throws InterruptedException
    {
        //move to the register page
        withExplicitWaitScrollOn(registerLinkPage);
        clickOn(registerLinkPage);

        withExplicitWaitScrollOn(firstName);
        typeOn(firstName, registerFormModel.getFirstName());

        withExplicitWaitScrollOn(lastName);
        typeOn(lastName, registerFormModel.getLastName());

        withExplicitWaitScrollOn(address);
        typeOn(address, registerFormModel.getAddress());

        withExplicitWaitScrollOn(city);
        typeOn(city, registerFormModel.getCity());

        withExplicitWaitScrollOn(state);
        typeOn(state, registerFormModel.getState());

        withExplicitWaitScrollOn(zipCode);
        typeOn(zipCode, registerFormModel.getZip());

        withExplicitWaitScrollOn(phone);
        typeOn(phone, registerFormModel.getPhone());

        withExplicitWaitScrollOn(ssn);
        typeOn(ssn, registerFormModel.getSsn());

        withExplicitWaitScrollOn(userName);
        typeOn(userName, registerFormModel.getUser());

        withExplicitWaitScrollOn(password);
        typeOn(password, registerFormModel.getPassword());

        withExplicitWaitScrollOn(repeatedPassword);
        typeOn(repeatedPassword, registerFormModel.getPassword());

        doSubmit(register);
    }

    public void withExplicitWaitFillRegisterFormModel() throws InterruptedException
    {
        //move to the register page
        withExplicitWaitScrollOn(registerLinkPage);
        withExplicitWaitClickOn(registerLinkPage);

        withExplicitWaitScrollOn(firstName);
        withExplicitWaitTypeOn(firstName, registerFormModel.getFirstName());

        withExplicitWaitScrollOn(lastName);
        withExplicitWaitTypeOn(lastName, registerFormModel.getLastName());

        withExplicitWaitScrollOn(address);
        withExplicitWaitTypeOn(address, registerFormModel.getAddress());

        withExplicitWaitScrollOn(city);
        withExplicitWaitTypeOn(city, registerFormModel.getCity());

        withExplicitWaitScrollOn(state);
        withExplicitWaitTypeOn(state, registerFormModel.getState());

        withExplicitWaitScrollOn(zipCode);
        withExplicitWaitTypeOn(zipCode, registerFormModel.getZip());

        withExplicitWaitScrollOn(phone);
        withExplicitWaitTypeOn(phone, registerFormModel.getPhone());

        withExplicitWaitScrollOn(ssn);
        withExplicitWaitTypeOn(ssn, registerFormModel.getSsn());

        withExplicitWaitScrollOn(userName);
        withExplicitWaitTypeOn(userName, registerFormModel.getUser());

        withExplicitWaitScrollOn(password);
        withExplicitWaitTypeOn(password, registerFormModel.getPassword());

        withExplicitWaitScrollOn(repeatedPassword);
        withExplicitWaitTypeOn(repeatedPassword, registerFormModel.getPassword());

        withExplicitWaitDoSubmit(register);
    }

    public List<String> isRegisterFormDone()
    {
        List <String> submittedRegisterResult = new ArrayList <String>();
        submittedRegisterResult.add(getText(welcomeUser).trim());
        submittedRegisterResult.add(getText(welcomeMessage).trim());
        return submittedRegisterResult;
    }

}
