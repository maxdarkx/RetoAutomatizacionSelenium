package com.juancarlosmaya.stepdefinition.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.juancarlosmaya.util.Log4jValues.*;

public class WebUI {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_LINUX_CHROME_DRIVER_PATH = "src/test/resources/driver/chrome/linux/chromedriver";
    private static final String WEBDRIVER_WINDOWS_CHROME_DRIVER_PATH = "src/test/resources/driver/chrome/windows/chromedriver.exe";
    private String os;

    private static final String RETO_URL = "https://parabank.parasoft.com";

    protected WebDriver driver;

    protected void setUpWebDriver(){
        //os = System.getProperty("os.name").toLowerCase();
        switch (os) {
            case "win":
                System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_WINDOWS_CHROME_DRIVER_PATH);
                break;
            case "lin":
                System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_LINUX_CHROME_DRIVER_PATH);
                break;
        }
    }

    protected void generalSetUp(){

        driver = new ChromeDriver();
        driver.get(RETO_URL);
        //driver.manage().window().maximize();
    }

    protected void setUpLog4j2(){
        os = System.getProperty("os.name").toLowerCase().substring(0,3);
        switch (os)
        {
            case "win":
                PropertyConfigurator.configure(USER_DIR.value() + LOG4J_WINDOWS_PROPERTIES_FILE_PATH.getValue());
                break;
            case "lin":
                PropertyConfigurator.configure(USER_DIR.value() + LOG4J_LINUX_PROPERTIES_FILE_PATH.getValue());
                break;
        }

    }

    protected void quitDriver(){
        driver.quit();
    }

    protected void closeDriver()
    {
        driver.close();
    }
}
