package com.demoblaze.q_pros.screen.headers;

import com.demoblaze.q_pros.driver.DriverManager;
import com.demoblaze.q_pros.screen.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseScreen {
    private static String price ;
    public static void setPrice(String price) {
        HomePage.price = price;
    }
    public static String getPrice() {
        return price;
    }
    public void scrollToProductName(String productName) {
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[text()='"+productName+"']"));
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickOnProductName(String productName){
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[text()='"+productName+"']"));
        String index = element.getAttribute("href").split("=")[1];
        String priceXpath = constructPriceXpath(index);
        WebElement price = DriverManager.getWebDriver().findElement(By.xpath(priceXpath));
        setPrice(price.getText());
        element.click();
    }

    public String constructPriceXpath(String index){
        return "//*[@id='tbodyid']/div["+index+"]/div/div/h5".split("/$")[0];
    }

}


