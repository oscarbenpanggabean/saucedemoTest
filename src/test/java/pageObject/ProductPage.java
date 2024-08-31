package pageObject;

import org.openqa.selenium.By;

import function.BasePOM;

public class ProductPage extends BasePOM {

    By CART_BADGE = By.xpath("//span[@data-test='shopping-cart-badge']");
    By CART_ICON = By.xpath("//a[@data-test='shopping-cart-link']");
    By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    By MENUBAR = By.xpath("//div[@class='bm-menu-wrap']");

    public ProductPage() {
        super();
    }

    public int getCartBadgeNumber() {
        return Integer.valueOf(gen_fetch.getTextElement(CART_BADGE));
    }

    public void clickIconCart() {
        gen_act.clickElement(CART_ICON);
    }

    public void clickBurgerMenu() {
        gen_act.clickElement(BURGER_MENU_BUTTON, "clickable");
    }

    public boolean isMenuBarExpanded() {
        return gen_fetch.isElementDisplayed(MENUBAR)
                && gen_fetch.getElementAttribute(MENUBAR, "aria-hidden").equalsIgnoreCase("false");
    }

}
