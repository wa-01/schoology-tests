package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resource extends AbstractPage {

    private static final String RESOURCE_TYPE = "//a[contains(text(),'%s')]";
    private static final String RESOURCE_CHECKBOX = "//a[contains(text(),'%s')]//ancestor::tr//descendant::input";

    @FindBy(xpath = "//span[contains(text(),'Add Resources')]")
    private WebElement addResourcesButton;

    @FindBy(css = "#edit-title")
    private WebElement folderInput;

    @FindBy(css = "input[value='Create']")
    private WebElement createButton;

    @FindBy(xpath = "//td[@class='collection-item-title collection-item-is-folder']//child::a")
    private WebElement createdFolder;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    private WebElement resourceEditButton;

    @FindBy(css = "li[class='action-delete']")
    private WebElement resourceDeleteButton;

    @FindBy(xpath = "//span[@class='submit-span-wrapper']//child::input[@value='Delete']")
    private WebElement deleteButton;

    public void clickAddResourcesButton() {
        action.click(addResourcesButton);
    }

    public void clickAddResourceButton(String resourceName){
        String resourceLocator = String.format(RESOURCE_TYPE, resourceName);
        action.click(By.xpath(resourceLocator));
    }

    public void addFolderName(String folderName){
        wait.until(ExpectedConditions.elementToBeClickable(folderInput));
        action.setValue(folderInput, folderName);
    }

    public void clickCreateButton(){
        action.click(createButton);
    }

    public String getFolderName(){
        return action.getText(createdFolder);
    }

    public void clickResourceCheckbox(String resourceName) {
        String resourceCheckboxLocator = String.format(RESOURCE_CHECKBOX, resourceName);
        action.click(By.xpath(resourceCheckboxLocator));
    }

    public void clickResourceEditButton(){
        action.click(resourceEditButton);
    }

    public void clickResourceDeleteButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(resourceDeleteButton));
        action.click(resourceDeleteButton);
    }

    public void clickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        action.click(deleteButton);
    }

}
