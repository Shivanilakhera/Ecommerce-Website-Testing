package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        homePage.clickSignIn();
        loginPage = new LoginPage(driver);
    }

    @When("I enter my username and password")
    public void i_enter_username_and_password() {
        loginPage.enterEmail("your_registered_email@mail.com");
        loginPage.enterPassword("Test@1234");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickSignIn();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in() {
        // Add assertion for successful login like greeting or logout link
        driver.quit();
    }
}
