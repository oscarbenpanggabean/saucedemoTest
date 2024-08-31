package function;

import org.openqa.selenium.By;

public class GeneralFetch extends BaseFunction {

    GeneralSupport sprt;

    public GeneralFetch() {
        super();
        sprt = new GeneralSupport();
    }

    public boolean isElementDisplayed(By locator) {
        return sprt.getElement(locator).isDisplayed();
    }

    public String getElementAttribute(By locator, String attribute) {
        return sprt.getElement(locator).getAttribute(attribute);
    }

    public String getTextElement(By locator) {
        return sprt.getElement(locator, "visible").getText();
    }


    
}
