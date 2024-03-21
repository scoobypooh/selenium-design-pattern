package com.udemy.seleniumdesign.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashBoardPage {
    private WebDriver driver;
    @FindBy(id="role")
    private WebElement role;

    @FindBy(css="div.guest")
    private List<WebElement> guestComponenets;
    @FindBy(css="div.superuser")
    private List<WebElement> superuserComponenets;
    @FindBy(css="div.admin")
    private List<WebElement> adminComponenets;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }
    public void selectRole(String role){
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getAdminComponenets() {
        return adminComponenets;
    }

    public List<WebElement> getGuestComponenets() {
        return guestComponenets;
    }

    public List<WebElement> getSuperuserComponenets() { //te
        return superuserComponenets;
    }
}
