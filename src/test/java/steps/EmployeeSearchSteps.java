package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.xpath("(//*[text()='PIM'])[1]"));
      //  pimOption.click();
        click(pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.xpath("//*[text()='Employee List']"));
        //empListOption.click();
        click(empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement empIdSearchField = driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]"));
     //   empIdSearchField.sendKeys("EMP001");
        sendText("EMP001", empIdSearchField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
      //  searchButton.click();
        click(searchButton);
    }

    @Then("user is able to see the employee details")
    public void user_is_able_to_see_the_employee_details() {
        System.out.println("employee details appeared");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        WebElement empNameSearchField = driver.findElement(By.xpath("(//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[1]"));
      //  empNameSearchField.sendKeys("John");
        sendText("john", empNameSearchField);
    }
}
