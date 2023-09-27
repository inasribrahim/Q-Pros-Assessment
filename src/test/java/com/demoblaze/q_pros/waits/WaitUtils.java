package com.demoblaze.q_pros.waits;

import com.demoblaze.q_pros.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    static long waitTime = 35 ;

    public static WebElement waitUntilElementIsPresence(By by){
        if (by == null) {
            throw new IllegalArgumentException("Input must be set");
        }
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitUntilElementUntilIsClickable(By by){
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    public static  WebElement waitUntilElementUntilIsVisible(By by){
        if (by == null) {
            throw new IllegalArgumentException("Input must be set");
        }
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static  void sleep(final long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void waitUntilAlertIsPresence(){
         new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.alertIsPresent());
    }
}
