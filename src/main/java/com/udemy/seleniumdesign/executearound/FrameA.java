package com.udemy.seleniumdesign.executearound;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameA {

    @FindBy(name = "fn")
    public WebElement firstName;
    @FindBy(name = "ln")
    public WebElement lastName;
    @FindBy(name = "addr")
    public WebElement address;

    @FindBy(id = "area")
    public WebElement message;

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setMessage(String message) {
        this.message.sendKeys(message);
    }
}
