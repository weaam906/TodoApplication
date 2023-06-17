package com.weaamk.todo.testcases;

import com.weaamk.todo.base.BaseTest;
import com.weaamk.todo.pages.LoginPage;
import com.weaamk.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailandPassword(){
       String website="https://qacart-todo.herokuapp.com";
       //1-Create an object from login page & Todo page
       LoginPage loginPage = new LoginPage(webDriver);
       //2-Pass the website link to the web-driver.get and Pass the credential
       //This is a builder pattern that navigate from method to another n the same page
       //without creating another object
       //3-Check if the page element is displayed or not
        boolean welcomePageIsDisplayed = loginPage
               .load()
               .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
               .welcomePageIsDisplayed();
       //4-Verify the result
       Assert.assertTrue(welcomePageIsDisplayed);
    }
}
