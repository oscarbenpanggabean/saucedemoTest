package function;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralSupport extends BaseFunction {

    GeneralWait generalWait;

    public GeneralSupport() {
        super();
        generalWait = new GeneralWait();
    }

    public WebElement getElement(By locator, String condition) {
        generalWait.waitElement(locator, condition);
        usedElement = driver.findElement(locator);
        return usedElement;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By buttonLocator) {
        return driver.findElements(buttonLocator);
    }

}
