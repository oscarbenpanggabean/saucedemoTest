package function;

import java.util.ArrayList;
import java.util.List;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class GeneralWait extends BaseFunction {

  protected Wait<WebDriver> customWait;
  int defaultTimeout = 5; // second
  int defaultPolling = 200; // milisecond

  public GeneralWait() {
    super();
    customWait = new FluentWait<WebDriver>(driver);
  }

  /**
   * Set global implicit wait time
   * 
   * @param seconds timeout in seconds
   */
  public void setImplicitWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
  }

  /**
   * Reset global implicit wait time (Default to {@value 5} second)
   */
  public void resetImplicitWait() {
    setImplicitWait(defaultTimeout);
  }

  /**
   * Construct a FluentWait object to be used as wait instance
   * 
   * @param timeout      in seconds
   * @param pollingMills inspection polling interval
   * @return Wait instance (tied to used driver instance)
   */
  public Wait<WebDriver> constructFluentWait(long timeout, long pollingMills) {
    Wait<WebDriver> customWait = new FluentWait<WebDriver>(this.driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofMillis(pollingMills))
        .ignoreAll(new ArrayList<Class<? extends Throwable>>() {
          {
            // add(StaleElementReferenceException.class);
            add(NoSuchElementException.class);
            add(TimeoutException.class);
            add(InvalidElementStateException.class);
            add(WebDriverException.class);
          }
        })
        .withMessage("The message you will see in if a TimeoutException is thrown");
    return customWait;
  }

  /**
   * Construct a FluentWait object to be used as wait instance
   * 
   * @param timeout in seconds
   * @return Wait instance (tied to used driver instance)
   */
  public Wait<WebDriver> constructFluentWait(long timeout) {
    return constructFluentWait(timeout, defaultPolling);
  }

  /**
   * Construct a FluentWait object to be used as wait instance using default
   * settings
   * 
   * @return Wait instance (tied to used driver instance)
   */
  public Wait<WebDriver> constructFluentWait() {
    return constructFluentWait(defaultTimeout, defaultPolling);
  }

  public void waitElement(By locator, String condition) {
    Wait<WebDriver> customWait = constructFluentWait(this.defaultTimeout);
    switch (condition) {
      case "clickable":
        customWait.until(ExpectedConditions.elementToBeClickable(locator));
        break;
      case "visible":
        customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        break;
      case "presence":
        customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        break;
      case "invisible":
        customWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        break;
      default:
        break;
    }
  }

  public void waitElement(WebElement element, String condition) {
    Wait<WebDriver> customWait = constructFluentWait(this.defaultTimeout);
    switch (condition) {
      case "clickable":
        customWait.until(ExpectedConditions.elementToBeClickable(element));
        break;
      case "visible":
        customWait.until(ExpectedConditions.visibilityOf(element));
        break;
      case "invisible":
        customWait.until(ExpectedConditions.invisibilityOf(element));
        break;
      default:
        break;
    }
  }

  public void waitElement(By locator, String condition, int timeout) {
    Wait<WebDriver> customWait = constructFluentWait(timeout);
    switch (condition) {
      case "clickable":
        customWait.until(ExpectedConditions.elementToBeClickable(locator));
        break;
      case "visible":
        customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        break;
      case "presence":
        customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        break;
      case "invisible":
        customWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        break;
      default:
        break;
    }
  }

  public List<WebElement> waitElements(Wait<WebDriver> customWait, By locator, String condition) {
    switch (condition) {
      case "visible":
        listElement = customWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        break;
      case "presence":
        listElement = customWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        break;
      default:
        break;
    }
    return listElement;
  }

}
