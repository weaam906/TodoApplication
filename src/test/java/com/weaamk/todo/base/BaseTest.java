/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 16th.Apr.23 8                                   *
 *  Desc: This package is for initializing the webDriver  *
 *        and close it before and after each method       *
 * ****************************************************** */
package com.weaamk.todo.base;

import com.weaamk.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected WebDriver webDriver;
  @BeforeMethod
  public void setUp(){
    webDriver = new DriverFactory().webDriverInit();
  }

  @AfterMethod
  public void tearDown(){
      webDriver.quit();
  }
}
