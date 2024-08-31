package function;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driverFactory.Configuration;
import driverFactory.DriverFactory;

public class BaseFunction {

    protected WebDriver driver;
    protected Actions action;
    
    protected WebElement usedElement = null; // Temporary WebElement object to store used element
    protected List<WebElement> listElement = null;

    protected Configuration configuration = new Configuration();

    public BaseFunction() {
        this.driver = DriverFactory.getDriver();
        this.action = new Actions(driver);
    }
}
