package com.juancarlosmaya.page.loginform;

import com.juancarlosmaya.model.loginform.LoginFormModel;
import com.juancarlosmaya.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginFormPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(LoginFormPage.class);
    private LoginFormModel loginFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo";

    //For web page inicialization

    @CacheLookup
    @FindBy(xpath="//input[@name='username']")
    private WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement logIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/h1")
    private WebElement accountOverview;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement errorPassword;


    public LoginFormPage(WebDriver driver, LoginFormModel loginFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.loginFormModel = loginFormModel;
    }

    public LoginFormPage(WebDriver driver, int seconds, boolean explicitTime, LoginFormModel loginFormModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.loginFormModel = loginFormModel;
    }

    //with implicit wait
    public void fillLoginFormModel() throws  InterruptedException
    {
        scrollOn(userName);
        typeOn(userName, loginFormModel.getLogin());

        scrollOn(password);
        typeOn(password, loginFormModel.getPassword());

        doSubmit(logIn);
    }

    public String isLoginFormDone()
    {
        return getText(accountOverview).trim();
    }

    public String isLoginFormError()
    {
        return getText(errorPassword).trim();
    }
    //

    //with explicit wait

    public void withExplicitWaitFillLoginFormModel() throws InterruptedException
    {
        withExplicitWaitScrollOn(userName);
        withExplicitWaitTypeOn(userName, loginFormModel.getLogin());

        withExplicitWaitScrollOn(password);
        withExplicitWaitTypeOn(password, loginFormModel.getPassword());

        withExplicitWaitDoSubmit(logIn);
    }

    public String withExplicitWaitIsLoginFormDone()
    {
        return withExplicitWaitGetText(accountOverview).trim();
    }

    public String withExplicitWaitIsLoginFormError()
    {
        return withExplicitWaitGetText(errorPassword).trim();
    }
    //


}
