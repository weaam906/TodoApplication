/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 17th.Apr.23 8                                   *
 *  Desc: This package is for finding the pages locators  *
 *        (Login page)using POM design pattern and FindBy *
 *        annotation that takes the locator type as a     *
 *        parameter and returns the WebElement            *
 * ****************************************************** */
package com.weaamk.todo.pages;

import com.weaamk.todo.base.BasePage;
import com.weaamk.todo.utils.ConfigUtils;
import com.weaamk.todo.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {
    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailTextField;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordTextField;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //This method return the same page to reuse it again directly
    public LoginPage load(){
      //Here we get the properties from the utils file, then pass the property value to the webDriver
        /*
        Properties properties = PropertiesUtil
                               .loadProperties("src/test/java/com/weaamk/to-do/config/production.properties"
        webDriver.get(properties.getProperty("baseUrl"));
         */
        webDriver.get(ConfigUtils.getInstance().getBaseUrl()); // Here we get the basUrl directly from the static method
        return this;
    }

    public TodoPage login(String email,String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        submitButton.click();
        return new TodoPage(webDriver);
    }

}
