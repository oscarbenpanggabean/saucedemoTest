package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import function.BasePOM;
import io.cucumber.java.en.*;

public class GeneralStep extends BasePOM{

    public GeneralStep(){
        super();
    }

    @Given("user is on url {string}")
    public void user_is_on_url(String expectedUrl){
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @When("user fill {string} in {string} Textbox")
    public void user_fill_in_textbox(String value, String textbox) {
        By textboxLocator = By.xpath("//input[@placeholder='"+textbox+"']");
        gen_act.fillText(textboxLocator,value);
    }

    @Then("Textbox {string} is filled by {string}")
    public void Textbox_is_filled_by(String textbox, String expectedValue) {
        By textboxLocator = By.xpath("//input[@placeholder='"+textbox+"']");
        assertEquals(expectedValue, gen_fetch.getElementAttribute(textboxLocator, "value"));
    }

    @Then("user click on {string} Button")
    public void user_click_on_Button(String button) {
        By buttonLocator = By.xpath("//*[@value='"+button+"']");
        gen_act.clickElement(buttonLocator);
    }

    @Then("user is navigated to {string} page")
    public void user_is_navigated_to_page(String title) {
        By titleLocator = By.xpath("//span[@data-test='title']");
        assertTrue(gen_fetch.isElementDisplayed(titleLocator));
        assertTrue(gen_fetch.getTextElement(titleLocator).equalsIgnoreCase(title));
    }

    
}
