package stepDefinition;

import io.cucumber.java.en.*;

public class GeneralStep {

    @When("user fill {string} in {string} Textbox")
    public void user_fill_in_textbox(String value, String textbox) {

    }

    @Then("Textbox {string} is filled by {string}")
    public void Textbox_is_filled_by(String s, String s2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("user click on {string} Button")
    public void user_click_on_Button(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    
}
