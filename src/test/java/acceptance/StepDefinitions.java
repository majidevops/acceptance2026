package acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.chaffai.calculatrice.Calculatrice;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    
    @Autowired
    private Calculatrice calculatrice;
    
    private int number1;
    private int number2;
    private int result;

    @Given("I have two numbers: {int} and {int}")
    public void i_have_two_numbers(int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
        // Spring injecte automatiquement 'calculatrice' grâce à @Autowired
    }

    @When("the calculator sums them")
    public void the_calculator_sums_them() {
        this.result = calculatrice.sum(number1, number2);
    }

    @Then("I should get {int} as result")
    public void i_should_get_as_result(int expectedResult) {
        assertEquals("Expected " + expectedResult + " but got " + result, expectedResult, result);
    }
}
