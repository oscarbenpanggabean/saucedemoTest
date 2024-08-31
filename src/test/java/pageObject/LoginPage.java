package pageObject;

import org.openqa.selenium.By;

import function.BasePOM;

public class LoginPage extends BasePOM {

    By LOGIN_BUTTON = By.id("login-button");

    public LoginPage() {
        super();
    }

    public boolean isLoginButtonDisplayed() {
        return gen_fetch.isElementDisplayed(LOGIN_BUTTON);
    }

    public void clickButtonLogin() {
        gen_act.clickElement(LOGIN_BUTTON);
    }

}
