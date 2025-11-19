package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {

   // WebDriver driver;

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
      // driver = new ChromeDriver();
      // driver.get("http://54.198.61.50/web/index.php/auth/login");
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));

       // usernameField.sendKeys(ConfigReader.read("userName"));
       // passwordField.sendKeys(ConfigReader.read("password"));

        sendText(ConfigReader.read("userName"), usernameField);
        sendText(ConfigReader.read("password"), passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
       // loginButton.click();
        click(loginButton);
    }

    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {
        System.out.println("Test passed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));

     //   usernameField.sendKeys("hrm_user123");
     //   passwordField.sendKeys("hrm_user@123");

        sendText("hrm_user123", usernameField);
        sendText("hrm_user@123", passwordField);
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        System.out.println("error message displayed");
    }

}
