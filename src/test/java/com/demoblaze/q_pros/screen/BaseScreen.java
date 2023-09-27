package com.demoblaze.q_pros.screen;


import com.demoblaze.q_pros.driver.DriverManager;
import com.demoblaze.q_pros.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;


public class BaseScreen extends WaitUtils {

    public String getElementText(By by){
        return waitUntilElementIsPresence(by).getText();
    }

    public String getCurrentUrl(){
        return DriverManager.getWebDriver().getCurrentUrl();
    }
    public void back() {
        DriverManager.getWebDriver().navigate().back();
    }

    public String getAlertMessage(){
        waitUntilAlertIsPresence();
        return DriverManager.getWebDriver().switchTo().alert().getText();
    }

    public void clickOnOkInAlert(){
        DriverManager.getWebDriver().switchTo().alert().accept();
    }
}
