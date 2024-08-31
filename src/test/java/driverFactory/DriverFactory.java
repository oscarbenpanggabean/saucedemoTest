package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public Configuration configuration = new Configuration();

    public WebDriver init(Scenario scenario) {
        if (configuration.isHeadless) {
            switch (configuration.browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    threadLocalDriver.set(new ChromeDriver(options));
                    break;
                default:
                    System.out.println("Please pass the correct browser value: " + configuration.browser);
                    break;
            }
        } else {
            switch (configuration.browser) {
                case "chrome":
                    // WebDriverManager.chromedriver().clearDriverCache().setup();
                    // WebDriverManager.chromedriver().clearResolutionCache().setup();
                    WebDriverManager.chromedriver().setup();
                    threadLocalDriver.set(new ChromeDriver());
                    break;
                default:
                    System.out.println("Please pass the correct browser value: " + configuration.browser);
                    break;
            }
        }

        // WebDriver's global settings
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Return created webDriver
        return getDriver();
    }

    /**
     * Main method to get used WebDriver instance
     * 
     * @return Initialized WebDriver / Driver instance
     */
    public static synchronized WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
