package stepDefinition;


import static org.junit.Assert.assertTrue;

import function.BasePOM;
import io.cucumber.java.en.*;
import pageObject.LoginPage;

public class LoginStep extends BasePOM {

    LoginPage loginPage;

    public LoginStep() {
        super();
        loginPage = new LoginPage();
    }

    @Given("user is navigated to Login Page")
    public void user_is_navigated_to_Login_Page() {
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @When("user click on LOGIN Button")
    public void user_click_on_LOGIN_Button() {
        loginPage.clickButtonLogin();
    }
}
