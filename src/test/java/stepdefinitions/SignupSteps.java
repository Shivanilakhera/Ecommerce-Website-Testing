package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignupSteps {
    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;

    @Given("I navigate to the Magento homepage")
    public void i_navigate_to_the_homepage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @When("I go to the create account page")
    public void i_go_to_create_account_page() {
        homePage.clickCreateAccount();
        signUpPage = new SignUpPage(driver);
    }

    @When("I enter valid signup details")
    public void i_enter_valid_signup_details() {
        signUpPage.enterFirstName("Test");
        signUpPage.enterLastName("User");
        signUpPage.enterEmail("testuser" + System.currentTimeMillis() + "@mailinator.com");
        signUpPage.enterPassword("Test@1234");
        signUpPage.enterConfirmPassword("Test@1234");
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        signUpPage.clickCreateAccount();
    }

    @Then("My account should be created successfully")
    public void account_should_be_created() {
        // Add assertion or check element like "Welcome" or logout link
        driver.quit();
    }
}
