package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import function.BasePOM;
import io.cucumber.java.en.*;
import pageObject.ProductPage;

public class ProductStep extends BasePOM {

    ProductPage productPage;

    public ProductStep() {
        super();
        productPage = new ProductPage();
    }

    @When("user click Button {string} on product {string}")
    public void user_click_Button_on_product(String button, String product) {
        By buttonLocator = By.xpath("//div[@data-test='inventory-item-name'][text()='" + product
                + "']/ancestor::div[@data-test='inventory-item']//button[text()='" + button + "']");
        gen_act.clickElement(buttonLocator, "clickable");
    }

    @Then("on product {string} Button {string} is {string}")
    public void on_product_Button_is(String product, String button, String condition) {
        By buttonLocator = By.xpath("//div[@data-test='inventory-item-name'][text()='" + product
                + "']/ancestor::div[@data-test='inventory-item']//button[text()='" + button + "']");
        switch (condition) {
            case "appear":
                assertTrue(gen_fetch.isElementDisplayed(buttonLocator));
                break;
            case "disappear":
                assertFalse(gen_sprt.getElements(buttonLocator).size() > 0);
                break;
            default:
                assertTrue(false);
                break;
        }
    }

    @Then("ICON CART BADGE is filled by number {int}")
    public void ICON_CART_BADGE_is_filled_by_number(int expectedTotal) {
        assertEquals(expectedTotal, productPage.getCartBadgeNumber());
    }

    @When("user click on ICON CART")
    public void user_click_on_ICON_CART() {
        productPage.clickIconCart();
    }

    @Then("validate product {string} is {string}")
    public void validate_product_is(String product, String condition) {
        By itemLocator = By.xpath("//div[@data-test='inventory-item-name'][text()='" + product + "']");
        switch (condition) {
            case "exists":
                assertTrue(gen_fetch.isElementDisplayed(itemLocator));
                break;
            case "not exists":
                assertFalse(gen_sprt.getElements(itemLocator).size() > 0);
                break;
            default:
                assertTrue(false);
                break;
        }
    }

    @When("user click on BURGER MENU Button")
    public void user_click_on_BURGER_MENU_Button() throws InterruptedException {
        productPage.clickBurgerMenu();
    }

    @Then("MENU BAR is {string}")
    public void MENU_BAR_is(String condition) {
        switch (condition) {
            case "expanded":
                assertTrue(productPage.isMenuBarExpanded());
                break;
            case "collapsed":
                assertFalse(productPage.isMenuBarExpanded());
                break;
            default:
                break;
        }
    }

    @Then("MENU {string} is {string}")
    public void MENU_is(String menu, String condition) {
        By menuLocator = By.xpath("//a[contains(@data-test,'sidebar-link')][text()='"+menu+"']");
        switch (condition) {
            case "appear":
                gen_wait.waitElement(menuLocator, "visible");
                assertTrue(gen_fetch.isElementDisplayed(menuLocator));
                break;
            case "disappear":
                assertFalse(gen_fetch.isElementDisplayed(menuLocator));
                break;
            default:
                assertTrue(false);
                break;
        }
    }

    @When("user click on MENU {string}")
    public void user_click_on_MENU(String menu) {
        By menuLocator = By.xpath("//a[contains(@data-test,'sidebar-link')][text()='"+menu+"']");
        gen_act.clickElement(menuLocator,"clickable");
    }

}
