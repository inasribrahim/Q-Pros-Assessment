package com.demoblaze.q_pros.screen.headers;

import com.demoblaze.q_pros.screen.BaseScreen;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.demoblaze.q_pros.waits.WaitUtils.*;

public class SignUpPage extends BaseScreen {
    private static String lastName ;
    private final By usernameTextField = By.id("sign-username");
    private final By passwordTextField = By.id("sign-password");
    private final By signUpButton = By.xpath("//button[text()='Sign up']");
    private final By closeButton = By.xpath("//button[text()='Close']");
    private final By xButton = By.xpath("//span[text()='×'])[2]");

    private String signUpSuccessMessageAlert = "Sign up successful.";
    private String userExistedMessage = "This user already exist.";
    private String emptyFieldMessage = "Please fill out Username and Password.";

    private SignUpPage enterUsername(String username){
        waitUntilElementUntilIsVisible(usernameTextField).sendKeys(username);
        return this;
    }

    private SignUpPage enterPassword(String password){
        waitUntilElementUntilIsVisible(passwordTextField).sendKeys(password);
        return this;
    }

    public SignUpPage clickOnSignUp(){
        waitUntilElementUntilIsClickable(signUpButton).click();
        return this;
    }

    public void clickOnXButton(){
        waitUntilElementUntilIsClickable(xButton).click();
    }

    public void clickOnClose(){
        waitUntilElementUntilIsClickable(closeButton).click();
    }

    public void SignUp(String username,String password){
        enterUsername(username).enterPassword(password).clickOnSignUp();
    }

    public void checkSignUpSuccessMessage(){
        Assert.assertEquals(getAlertMessage(),signUpSuccessMessageAlert);
    }

    public void checkUserExistedMessage(){
        Assert.assertEquals(getAlertMessage(),userExistedMessage);
    }

    public void checkUserFieldEmptyMessage(){
        Assert.assertEquals(getAlertMessage(),emptyFieldMessage);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getLastName() {
        return lastName;
    }

}
