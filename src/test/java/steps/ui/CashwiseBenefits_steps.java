package steps.ui;

import com.google.j2objc.annotations.Weak;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CashwiseLoginPage;
import utilities.Flow;

import java.util.List;

public class CashwiseBenefits_steps {



    @When("user scrolls down to four offer benefits on homepage")
    public void user_scrolls_down_to_four_offer_benefits_on_homepage() {
        Flow.scrollDown(500);


    }
    @Then("user should see all four options of the offer benefits")
    public void user_should_see_all_four_options_of_the_offer_benefits(List<String> benefits)  {
        CashwiseLoginPage cashwiseLoginPage = new CashwiseLoginPage();
        for(WebElement benefit: cashwiseLoginPage.benefitList){
            String benefitString = benefit.getText().trim();
            Assert.assertTrue(benefits.contains(benefitString));
        }

    }

}
