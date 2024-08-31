package driverFactory;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private DriverFactory driverFactory;
    private Configuration configuration;

    private WebDriver driver;

    public Hooks() {
        configuration = new Configuration();
        driverFactory = new DriverFactory();
    }

    @Before(order = 0)
    public void launchBrowser(Scenario scenario) throws IOException {
        System.out.println("open the browser...");
        driver = driverFactory.init(scenario);
        driver.get(configuration.URL);
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws Exception {
        Boolean enableScreenshot = configuration.enableScreenshot;
        if (scenario.isFailed()) {
            if (enableScreenshot) {
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcePath, "image/png", screenshotName);
            }
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.close();
        driver.quit();
    }

}
