import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CucumberSteps {

    private String phoneNumber;

    @Given("I have a phone number {string}")
    public void i_have_a_phone_number(String phone) {
        this.phoneNumber = phone;
    }

    @When("I check the phone number")
    public void i_check_the_phone_number() {
    }

    @Then("the phone number should {string}")
    public void the_phone_number_should(String result) {
        if (result.equals("not be empty")) {
            assertFalse("Phone number is empty", phoneNumber.isEmpty());
        } else if (result.equals("be empty")) {
            assertTrue("Phone number is not empty", phoneNumber.isEmpty());
        }
    }

    @Then("the phone number should not be empty")
    public void theUserCreationShouldSucceedWithMessage() {
        assertFalse("Phone number is empty", phoneNumber.isEmpty());
    }

    @Then("the phone number should be empty")
    public void theUserCreationShouldFailWithMessage() {
        assertTrue("Phone number is not empty", phoneNumber.isEmpty());
    }
}
