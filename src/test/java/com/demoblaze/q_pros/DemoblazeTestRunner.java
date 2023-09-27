package com.demoblaze.q_pros;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/demoblaze/q_pros/tests",
        glue = {"com.demoblaze.q_pros.tests"},
        monochrome = true
)

public class DemoblazeTestRunner extends AbstractTestNGCucumberTests {

}
