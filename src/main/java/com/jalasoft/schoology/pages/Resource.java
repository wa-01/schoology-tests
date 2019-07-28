package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resource extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Add Resources')]")
    private WebElement addResourcesButton;

    @FindBy(xpath = "//a[contains(text(),'Add Folder')]")
    private WebElement addFolderButton;

    @FindBy(css = "#edit-title")
    private WebElement folderTitle;

    @FindBy(css = "input[value='Create']")
    private WebElement createButton;

    @FindBy(xpath = "//td[@class='collection-item-title collection-item-is-folder']//child::a")
    private WebElement createdFolder;

    public void clickAddResourcesButton(){
        action.click(addResourcesButton);
    }

    public void clickAddFolderButton(){
        action.click(addFolderButton);
    }

    public void addFolderName(String folderName){
        wait.until(ExpectedConditions.elementToBeClickable(folderTitle));
        action.setValue(folderTitle, folderName);
    }

    public void clickCreateButton(){
        action.click(createButton);
    }

    public String getFolderName(){
        return action.getText(createdFolder);
    }

}
