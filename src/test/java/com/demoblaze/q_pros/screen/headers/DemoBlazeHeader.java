package com.demoblaze.q_pros.screen.headers;

import com.demoblaze.q_pros.screen.BaseScreen;
import org.openqa.selenium.By;

import static com.demoblaze.q_pros.waits.WaitUtils.waitUntilElementUntilIsClickable;
import static com.demoblaze.q_pros.waits.WaitUtils.waitUntilElementUntilIsVisible;

public class DemoBlazeHeader extends BaseScreen {
    SignUpPage signUpPage;
    LoginPage loginPage;
    CartPage cartPage;
    private final By homeLink = By.xpath("//a[text()='Home ']");
    private final By contactLink = By.xpath("//a[text()='Contact']");
    private final By aboutUsLink = By.xpath("//a[text()='About us']");
    private final By cartLink = By.xpath("//a[text()='Cart']");
    private final By logInLink = By.xpath("//a[text()='Log in']");
    private final By signUpLink = By.xpath("//a[text()='Sign up']");
    private final By welcomeUsernameField = By.id("nameofuser");
    private final By logOutLink = By.id("logout2");

    public DemoBlazeHeader() {
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
         cartPage = new CartPage();
    }

    public HomePage clickOnHomeLink(){
        waitUntilElementUntilIsClickable(homeLink).click();
        return new HomePage();
    }
    public void clickOnContactLink(){
        waitUntilElementUntilIsClickable(contactLink).click();
    }

    public void clickOnAboutUs(){
        waitUntilElementUntilIsClickable(aboutUsLink).click();
    }

    public LoginPage clickOnLogInLink(){
        waitUntilElementUntilIsClickable(logInLink).click();
        return new LoginPage();
    }

    public SignUpPage clickOnSignUp(){
        waitUntilElementUntilIsClickable(signUpLink).click();
        return new SignUpPage();
    }
    public CartPage clickOnCart(){
        waitUntilElementUntilIsClickable(cartLink).click();
        return new CartPage();
    }

    public HomePage clickOnLogOut(){
        waitUntilElementUntilIsClickable(logOutLink).click();
        return new HomePage();
    }

    public String getWelcomeUsernameText() {
        return getElementText(welcomeUsernameField);
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public boolean logOutIsExisted(){
        return waitUntilElementUntilIsVisible(logOutLink).isDisplayed();
    }
}
