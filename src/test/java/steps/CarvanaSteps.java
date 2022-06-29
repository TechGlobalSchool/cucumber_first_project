package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.Select;
import pages.CarFinderPage;
import pages.CarvanaHomePage;
import pages.LoanCalculatorPage;
import utils.Waiter;

public class CarvanaSteps {

    CarvanaHomePage carvanaHomePage;
    CarFinderPage carFinderPage;
    LoanCalculatorPage loanCalculatorPage;

    @Before
    public void setupPages(){
        carvanaHomePage = new CarvanaHomePage();
        carFinderPage = new CarFinderPage();
        loanCalculatorPage = new LoanCalculatorPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        Hooks.driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        Waiter.pause(3);
        carvanaHomePage.clickOnHeaderItem(menuItem);
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, Hooks.driver.getCurrentUrl());
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carFinderPage.carvanaCarFinderHeading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carFinderPage.carvanaCarFinderHeading3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carFinderPage.headline.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carFinderPage.subHeading.getText());
                break;
            default:
                throw new NotFoundException("Text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String linkText) {
        Assert.assertEquals(linkText, carFinderPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkText) {
        carFinderPage.tryCarFinderLink.click();
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String menuItem) {
        carvanaHomePage.moveToHeaderItem(menuItem);
    }

    @And("user clicks on {string} finance menu item")
    public void userClicksOnHeaderMenuItem(String financeMenuItemText) {
        carvanaHomePage.clickOnFinanceItem(financeMenuItemText);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String inputBox, String input) {
        switch (inputBox){
            case "Cost of Car I want":
                loanCalculatorPage.costOfCarInputBox.sendKeys(input);
                break;
            case "What is Your Down Payment?":
                loanCalculatorPage.downPaymentInputBox.sendKeys(input);
                break;
            default:
            throw new NotFoundException("Input box is not defined properly in the feature file!!!");
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String dropdown, String option) {
        switch (dropdown){
            case "What’s Your credit Score?":
                new Select(loanCalculatorPage.creditScoreDropdown).selectByVisibleText(option);
                break;
            case "Choose Your Loan Terms":
                new Select(loanCalculatorPage.loanTermDropdown).selectByVisibleText(option);
                break;
            default:
                throw new NotFoundException("Input box is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyAmount) {
        Assert.assertEquals(monthlyAmount, loanCalculatorPage.monthlyPayment.getText());
    }
}
