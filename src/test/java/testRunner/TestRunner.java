package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinition", "driverFactory" },

        tags = "@RUN", plugin = { "pretty", "html:target/report.html", "junit:target/report.xml" }, monochrome = false)

class TestRunner {

}