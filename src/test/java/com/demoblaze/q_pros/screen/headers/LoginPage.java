package com.demoblaze.q_pros.screen.headers;

import com.demoblaze.q_pros.screen.BaseScreen;
import org.openqa.selenium.By;


public class LoginPage extends BaseScreen {
    private final By usernameTextField = By.id("loginusername");
    private final By passwordTextField = By.id("loginpassword");
    private final By logInButton = By.xpath("//button[text()='Log in']");
    private final By closeButton = By.xpath("//button[text()='Close']");

    private LoginPage enterUsername(String username)  {
        waitUntilElementUntilIsVisible(usernameTextField).sendKeys(username);
        return this;
    }

    private LoginPage enterPassword(String password){
        waitUntilElementIsPresence(passwordTextField).sendKeys(password);
        return this;
    }

    private LoginPage clickOnLogin(){
        waitUntilElementUntilIsClickable(logInButton).click();
        return this;
    }

    public void clickOnClose(){
        waitUntilElementUntilIsClickable(closeButton).click();
    }

    public void Login(String username,String password){
        enterUsername(username).enterPassword(password).clickOnLogin();
    }

}
