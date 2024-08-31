package driverFactory;

import org.openqa.selenium.WebDriver;

public class BaseCode {

    public WebDriver driver;
    public Configuration configuration;

    public String runtimeOS;

    public BaseCode() {

        configuration = new Configuration();
        runtimeOS = System.getProperty("os.name");
        driver = DriverFactory.getDriver();

    }
}
