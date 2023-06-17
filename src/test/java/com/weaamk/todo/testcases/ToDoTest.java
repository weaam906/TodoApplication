package com.weaamk.todo.testcases;

import com.weaamk.todo.base.BaseTest;
import com.weaamk.todo.pages.LoginPage;
import com.weaamk.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {

    @Test
    public void ShouldBeAbleToAddNewToDo(){
        String website="https://qacart-todo.herokuapp.com";
        //1-Create an object from login page
        LoginPage loginPage = new LoginPage(webDriver);
        //2-Pass the website link to the web-driver.get
        //3-Pass the credential
        //4-Create To-do page object
        //5-Create newToDo page object
        //6-Click on Add new to-do icon
        //7-Send text to the new to-do item
        //8- Validate the screen
        String actualText= loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickOnAddNewToDO()
                .submetNewTodo("Learn Selenium")
                .getToDoItemText();
        Assert.assertEquals(actualText,"Learn Selenium");
    }

    @Test (enabled = false)
    public void ShouldBeAbleToDeleteNewToDo(){
        String website="https://qacart-todo.herokuapp.com";
        //1-Create an object from login page
        LoginPage loginPage = new LoginPage(webDriver);
        //2-Pass the website link to the web-driver.get
        //3-Pass the credential
        //4-Create To-do page object
        //5-Create newToDo page object
        //6-Click on Add new ro-do icon
        //7-Send text to the new to-do item
        //8-Validate the screen
        //9-Delete the to-do
        boolean noToDoAvailableText= loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickOnAddNewToDO()
                .submetNewTodo("Learn Selenium")
                .deleteTodo()
                .getNoTodoAvailableText();
        //10-Validate the No to-do Available text
        Assert.assertTrue(noToDoAvailableText);
    }
}