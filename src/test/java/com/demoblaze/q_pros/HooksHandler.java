package com.demoblaze.q_pros;

import com.demoblaze.q_pros.driver.Driver;
import com.demoblaze.q_pros.tests.BaseTest;
import com.demoblaze.q_pros.utils.read_properties.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static com.demoblaze.q_pros.driver.Driver.initDriver;
import static com.demoblaze.q_pros.driver.Driver.setMaximizeBrowser;

public class HooksHandler extends BaseTest {
    public static String getBrowserName() throws IOException {
        return ReadProperties.setDemoBlazeConfig().getProperty("browserName");
    }

    @BeforeTest(alwaysRun = true)
    protected void setUp() throws IOException {
        initDriver(getBrowserName());
        setMaximizeBrowser();
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        Driver.closeDriver();
    }
}
