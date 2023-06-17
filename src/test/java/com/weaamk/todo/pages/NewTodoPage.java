/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 17th.Apr.23 8                                   *
 *  Desc: This package is for finding the pages locators  *
 *        (NewToDO page) using POM design pattern         *
 * ****************************************************** */
package com.weaamk.todo.pages;

import com.weaamk.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoTextField;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitNewTaskButton;

    public NewTodoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TodoPage submetNewTodo(String todoItemText){
        newTodoTextField.sendKeys(todoItemText);
        submitNewTaskButton.click();
        return new TodoPage(webDriver);
    }
}
