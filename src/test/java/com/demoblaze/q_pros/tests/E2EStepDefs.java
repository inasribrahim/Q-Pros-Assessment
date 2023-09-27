package com.demoblaze.q_pros.tests;

import com.demoblaze.q_pros.screen.DemoBlazeHome;
import com.demoblaze.q_pros.screen.headers.SignUpPage;
import com.demoblaze.q_pros.tests.BaseTest;
import com.demoblaze.q_pros.utils.generate_data.GenerateData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class E2EStepDefs extends BaseTest {

    private static String fullName ;
    private static int totalPrice ;
    GenerateData generateData = new GenerateData();
    @When("user enter a username {string} and password {string} and login")
    public void userEnterUsernameAndPasswordAndLogin(String username, String password) {
        fullName = username +"_" + SignUpPage.getLastName();
        browser.demoblaze.home.getHeader().clickOnLogInLink().Login(fullName,password);
    }
    @Then("validate that message should be {string} in alert")
    public void validateThatMessageShouldBeInAlert(String message) {
        Assert.assertEquals(browser.demoblaze.home.getHeader().getAlertMessage(),message);
        browser.demoblaze.home.getHeader().clickOnOkInAlert();
    }
    @Then("validate that user should be logged in and redirected to the home page")
    public void validateThatUserShouldBeLoggedInAndRedirectedToTheHomePage() {

    }

    @Then("validate that {string} should be appear in menu")
    public void validateThatShouldBeAppearInMenu(String username) {
        String fullName = username +"_" + SignUpPage.getLastName();
        Assert.assertTrue(browser.demoblaze.home.getHeader().getWelcomeUsernameText().contains(fullName));
    }

    @Then("validate that logout button should be appear in home page")
    public void validateThatLogoutButtonShouldBeAppearInHomePage() {
        Assert.assertTrue(browser.demoblaze.home.getHeader().logOutIsExisted());
    }

    @Given("click on sign up button in home page")
    public void clickOnSignUpButtonInHomePage() {
        browser.demoblaze.home.getHeader().clickOnSignUp();
    }

    @When("user enter a username {string} and password {string} in sign up page")
    public void userEnterAUsernameAndPassword(String username, String password) {
        browser.demoblaze.home.getHeader().getSignUpPage().setLastName(generateData.generateLastName());
        fullName = username +"_" + SignUpPage.getLastName();
        browser.demoblaze.home.getHeader().getSignUpPage().SignUp(fullName,password);
    }

    @When("user click on product name {string}")
    public void userClickOnProductName(String productName) {
        browser.demoblaze.home.scrollToProductName(productName).clickOnProductName(productName);
    }

    @Then("validate that product name should be {string}")
    public void validateThatProductNameShouldBe(String productName) {
        Assert.assertEquals(browser.demoblaze.home.getProductPage().getProductName(),productName);
    }

    @Then("validate that price of product should be the same")
    public void validateThatPriceOfProductShouldBeTheSame() {
        int price = DemoBlazeHome.getPrice();
        Assert.assertEquals(browser.demoblaze.home.getProductPage().getPrice(),price);
    }

    @When("click on add to cart button in product page")
    public void clickOnAddToCartButtonInProductPage() {
        browser.demoblaze.home.getProductPage().clickOnAddToCart();
    }

    @When("click on cart button in header")
    public void clickOnCartButtonInHeader() {
        browser.demoblaze.home.getHeader().clickOnCart();
    }

    @Then("validate that product name should be {string} in cart page")
    public void validateThatProductNameShouldBeInCartPage(String productName) throws InterruptedException {
        Assert.assertTrue(browser.demoblaze.home.getHeader().getCartPage().checkProductName(productName));
    }

    @And("validate that price of product name {string} should be the same in cart page")
    public void validateThatPriceOfProductNameShouldBeTheSameInCartPage(String productName) {
        int price = DemoBlazeHome.getPrice();
        Assert.assertEquals(browser.demoblaze.home.getHeader().getCartPage().getPrice(productName),price);
    }

    @And("validate that total price should be correct for all products")
    public void validateThatTotalPriceShouldBeCorrectForAllProducts() {
        totalPrice = browser.demoblaze.home.getHeader().getCartPage().getTotalPriceText();
        Assert.assertEquals(browser.demoblaze.home.getHeader().getCartPage().getAllPricesInProductList(), totalPrice);
    }

    @When("click on place order button in cart page")
    public void clickOnPlaceOrderButtonInCartPage() {
        browser.demoblaze.home.getHeader().getCartPage().clickOnPlaceOrder();
    }

    @And("fill country {string} and city {string} and credit cart {string} and month {string} and year {string}")
    public void fillCountryAndCityAndCreditCartAndMonthAndYear(String country, String city, String creditCart, String month, String year) {
    browser.demoblaze.home.getHeader().getCartPage().getPlaceOrderPage()
                                                    .setName(fullName)
                                                    .setCountry(country)
                                                    .setCity(city)
                                                    .setCardNumber(creditCart)
                                                    .setMonth(month)
                                                    .setYear(year);
    }

    @And("click on purchase button in place order screen")
    public void clickOnPurchaseButtonInPlaceOrderScreen() {
        browser.demoblaze.home.getHeader().getCartPage().getPlaceOrderPage().clickOnPurchase();
    }

    @And("validate that message after adding order in place order should be {string}")
    public void validateThatMessageAfterAddingOrderInPlaceOrderShouldBe(String message) throws InterruptedException {
        Assert.assertEquals(browser.demoblaze.home.getHeader().getCartPage().getPlaceOrderPage().getThanksMessage(),message);
        browser.demoblaze.home.getHeader().getCartPage().getPlaceOrderPage().clickOnOkButton();
    }

    @And("validate that total price should be correct in place order page")
    public void validateThatTotalPriceShouldBeCorrectInPlaceOrderPage() {
        Assert.assertEquals(browser.demoblaze.home.getHeader().getCartPage().getPlaceOrderPage().getPrice(),totalPrice);
    }
}
