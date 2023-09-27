package com.demoblaze.q_pros.screen;

import com.demoblaze.q_pros.driver.DriverManager;
import com.demoblaze.q_pros.screen.headers.DemoBlazeHeader;
import com.demoblaze.q_pros.screen.headers.HomePage;
import com.demoblaze.q_pros.screen.headers.LoginPage;
import com.demoblaze.q_pros.screen.headers.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DemoBlazeHome extends BaseScreen{
    private static String price ;
    DemoBlazeHeader header;
    LoginPage loginPage ;
    SignUpPage signUpPage;
    HomePage homePage;
    private ProductPage productPage;
    public DemoBlazeHome(){
        header = new DemoBlazeHeader();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    public DemoBlazeHeader getHeader(){
        return header;
    }
    public ProductPage getProductPage() {
        return productPage;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public static int getPrice() {
        String price_ =  price.split("\\$")[1];
        return Integer.parseInt(price_);
    }
    public DemoBlazeHome scrollToProductName(String productName) {
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[text()='"+productName+"']"));
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
          return this;
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
