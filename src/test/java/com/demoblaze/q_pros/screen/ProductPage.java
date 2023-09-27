package com.demoblaze.q_pros.screen;

import org.openqa.selenium.By;

public class ProductPage extends BaseScreen{
    private final By productNameHeader = By.tagName("h2");
    private final By priceTextHeader = By.tagName("h3");
    private final By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public String getProductName() {
        return getElementText(productNameHeader);
    }

    public int getPrice(){
        return Integer.parseInt(getElementText(priceTextHeader).split("\\$")[1].split(" ")[0]);
    }

    public void clickOnAddToCart(){
        waitUntilElementUntilIsClickable(addToCartButton).click();
    }


}
