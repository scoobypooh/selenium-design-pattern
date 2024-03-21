package com.udemy.seleniumdesign.Proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Paypal implements PaymentOption {

    @FindBy(id = "paypal_username")
    public WebElement paypal_username;

    @FindBy(id = "paypal_password")
    public WebElement paypal_password;


    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.paypal_username.sendKeys(paymentDetails.get("paypal_username"));
        this.paypal_password.sendKeys(paymentDetails.get("paypal_password"));
    }
}
