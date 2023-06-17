/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 16th.Apr.23 8                                   *
 *  Desc: This package is for initializing the webDriver  *
 *        using webDriverManager class in selenium 4      *
 * ****************************************************** */

package com.weaamk.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver webDriverInit(){
        WebDriver webDriver;

        String browser = System.getProperty("browser","CHROME");  //HERE we get the browser from the git terminal and if it's not
                                                                            //passed, the system will open chrome by default.
       // String browser = "CHROME"; //this is when we use the IDK without terminal
        switch (browser) {
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();                          //1- Set up the driver to be chrome
                webDriver = new ChromeDriver();                                   //2- Create an object from the chrome driver
            }
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();                         //1- Set up the driver to be firefox
                webDriver = new FirefoxDriver();                                  //2- Create an object from the firefox driver
            }
            case "SAFARI" -> webDriver = new SafariDriver();
            default -> throw new RuntimeException("The browser isn't supported");
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));     //3- Wait for a moment to load the browser
        return webDriver;
    }
}
