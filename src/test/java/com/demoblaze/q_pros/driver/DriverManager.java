package com.demoblaze.q_pros.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    public DriverManager(){}
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>();
    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }

    public static void setWebDriver(WebDriver webDriver){
        webDriverThreadLocal.set(webDriver);
    }

    public static void unLoad(){
        webDriverThreadLocal.remove();
    }
}
