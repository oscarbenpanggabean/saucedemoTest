package stepDefinition;

import static org.junit.Assert.assertEquals;

import function.BasePOM;
import io.cucumber.java.en.Then;

public class PageStep extends BasePOM {

    public PageStep() {
        super();
    }

    @Then("user is navigated to ABOUT page")
    public void user_is_navigated_to_ABOUT_page() {
        String expectedTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
        assertEquals(expectedTitle, driver.getTitle());
    }
}
