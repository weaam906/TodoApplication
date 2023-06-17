/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 17th.Apr.23 8                                   *
 *  Desc: This package is for finding the pages locators  *
 *        (To-do page) using POM design pattern           *
 * ****************************************************** */
package com.weaamk.todo.pages;

import com.weaamk.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addIcon;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement toDoItem;

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomePage;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteIcon;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noToDoAvailableText;

    public TodoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean welcomePageIsDisplayed(){
        return welcomePage.isDisplayed();
    }

    public NewTodoPage clickOnAddNewToDO(){
        addIcon.click();
        return new NewTodoPage(webDriver);
    }

    public String getToDoItemText(){
        return toDoItem.getText();
    }

    public TodoPage deleteTodo(){

        deleteIcon.click();
        return new TodoPage(webDriver);
    }

    public boolean getNoTodoAvailableText(){
       return noToDoAvailableText.isDisplayed();
    }
}


