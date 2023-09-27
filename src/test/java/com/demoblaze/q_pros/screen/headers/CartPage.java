package com.demoblaze.q_pros.screen.headers;

import com.demoblaze.q_pros.driver.DriverManager;
import com.demoblaze.q_pros.screen.BaseScreen;
import com.demoblaze.q_pros.screen.PlaceOrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BaseScreen {

    private PlaceOrderPage placeOrderPage;
    private final By totalPrice = By.id("totalp");
    private final By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private final By deleteButton = By.linkText("Delete");

    public CartPage() {
         placeOrderPage = new PlaceOrderPage();
    }

    public boolean checkProductName(String productName) throws InterruptedException {
        boolean flag = false;
        sleep(5000);
        WebElement tableContainer = DriverManager.getWebDriver().findElement(By.id("tbodyid"));
       List<WebElement> allRows = tableContainer.findElements(By.tagName("tr"));
        int rowsCount = allRows.size();
        for (int row = 0; row < rowsCount; row++) {
            List<WebElement> cells = allRows.get(row).findElements(By.xpath(".//*[local-name(.)='td']"));
            WebElement idColumn = cells.get(1);
            if (idColumn.getText().equalsIgnoreCase(productName)) {
                flag = true;
            }
        }
        return flag ;
    }

    public int getPrice(String productName){
        String price = "";
        WebElement tableContainer = DriverManager.getWebDriver().findElement(By.id("tbodyid"));
        List<WebElement> allRows = tableContainer.findElements(By.tagName("tr"));
        int rowsCount = allRows.size();
        for (int row = 0; row < rowsCount; row++) {
            List<WebElement> cells = allRows.get(row).findElements(By.xpath(".//*[local-name(.)='td']"));
            WebElement idColumn = cells.get(1);
            if (idColumn.getText().equalsIgnoreCase(productName)) {
                price = cells.get(2).getText();
            }
        }
        return Integer.parseInt(price) ;
    }

    public void deleteProductByName(String productName){
        WebElement tableContainer = DriverManager.getWebDriver().findElement(By.id("tbodyid"));
        List<WebElement> allRows = tableContainer.findElements(By.tagName("tr"));
        int rowsCount = allRows.size();
        for (int row = 0; row < rowsCount; row++) {
            List<WebElement> cells = allRows.get(row).findElements(By.xpath(".//*[local-name(.)='td']"));
            WebElement idColumn = cells.get(1);
            if (idColumn.getText().equalsIgnoreCase(productName)) {
                waitUntilElementUntilIsClickable(deleteButton).click();
            }
        }
    }

    public int getTotalPriceText(){
        return Integer.parseInt(getElementText(totalPrice));
    }
    public PlaceOrderPage getPlaceOrderPage() {
        return placeOrderPage;
    }
    public int getAllPricesInProductList() {
        int total = 0;
        List<WebElement> allPrices = DriverManager.getWebDriver().findElements(By.xpath("//tr[@class='success']/td[3]"));
        for(int i =0 ; i < allPrices.size() ; i++){
            total += Integer.parseInt(allPrices.get(i).getText());
        }
        return total;
    }
    public PlaceOrderPage clickOnPlaceOrder(){
        waitUntilElementUntilIsClickable(placeOrderButton).click();
        return new PlaceOrderPage();
    }

}
