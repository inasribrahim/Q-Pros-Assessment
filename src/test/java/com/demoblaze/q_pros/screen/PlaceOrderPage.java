package com.demoblaze.q_pros.screen;

import com.demoblaze.q_pros.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaceOrderPage extends BaseScreen {
    private final By totalPrice = By.id("totalm");
    private final By nameTextField = By.id("name");
    private final By countryTextField = By.id("country");
    private final By cityTextField = By.id("city");
    private final By cartField = By.id("card");
    private final By monthTextField = By.id("month");
    private final By yearTextField = By.id("year");
    private final By purchaseButton = By.xpath("//button[text()='Purchase']");
    private final By alertTable = By.cssSelector("body > div.sweet-alert.showSweetAlert.visible");

    public PlaceOrderPage setName(String name) {
        waitUntilElementUntilIsVisible(nameTextField).sendKeys(name);
        return this;
    }

    public PlaceOrderPage setCountry(String country) {
        waitUntilElementUntilIsVisible(countryTextField).sendKeys(country);
        return this;
    }

    public PlaceOrderPage setCity(String city) {
        waitUntilElementUntilIsVisible(cityTextField).sendKeys(city);
        return this;
    }

    public PlaceOrderPage setCardNumber(String cardNumber) {
        waitUntilElementUntilIsVisible(cartField).sendKeys(cardNumber);
        return this;
    }

    public PlaceOrderPage setMonth(String month) {
        waitUntilElementUntilIsVisible(monthTextField).sendKeys(month);
        return this;
    }

    public void setYear(String year) {
        waitUntilElementUntilIsVisible(yearTextField).sendKeys(year);
    }
    public void clickOnPurchase(){
        waitUntilElementUntilIsClickable(purchaseButton).click();
    }

    public int getPrice(){
        return Integer.parseInt(getElementText(totalPrice).split("Total: ")[1]);
    }

    public String getThanksMessage() throws InterruptedException {
        sleep(2000);
        WebElement successMessage = DriverManager.getWebDriver().findElement(alertTable).findElement(By.xpath("h2[text()='Thank you for your purchase!']"));
        return successMessage.getText();
    }

    public void clickOnOkButton(){
        WebElement ok = DriverManager.getWebDriver().findElement(alertTable).findElement(By.xpath("//button[text()='OK']"));
        ok.click();
    }
}
