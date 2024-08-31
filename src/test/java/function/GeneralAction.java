package function;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GeneralAction extends BaseFunction {

    Duration defaultWaitTime = Duration.ofMillis(15000);

    GeneralFetch fetch;
    GeneralSupport sprt;
    GeneralWait wait;
    ArrayList<String> newTab;

    public GeneralAction() {
        super();
        sprt = new GeneralSupport();
        fetch = new GeneralFetch();
        wait = new GeneralWait();
    }

    public void clickElement(By locator, String condition) {
        sprt.getElement(locator, condition).click();
    }

    public void clickElement(By locator) {
        sprt.getElement(locator).click();
    }

    public void fillText(By locator, String value) {
        deleteText(locator);
        sprt.getElement(locator).sendKeys(value);
    }

    public void deleteText(By textbox) {
        usedElement = sprt.getElement(textbox, "clickable");
        usedElement.click();
        usedElement.sendKeys(Keys.CONTROL, "a");
        usedElement.sendKeys(Keys.BACK_SPACE);
    }

    public void pressEnter() {
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void pressBackspace() {
        action.sendKeys(Keys.BACK_SPACE).build().perform();
    }

    public void hoverOn(By locator) {
        usedElement = sprt.getElement(locator, "visible");
        action.moveToElement(usedElement).perform();
    }

    

}
