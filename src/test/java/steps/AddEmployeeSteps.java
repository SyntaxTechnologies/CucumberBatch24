package steps;

import com.google.common.collect.Maps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DBUtils;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    String autoEmployeeId;
    String firstNameFE;
    String middleNameFE;
    String lastNameFE;


    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        // WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        click(dashboardPage.addEmpOption);
    }

    @When("user enters firstname and middle name and lastname")
    public void user_enters_firstname_and_middle_name_and_lastname() {
        //  WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        sendText("zara", addEmployeePage.firstNameloc);

        //WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        sendText("ms", addEmployeePage.middleNameloc);

        // WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        sendText("jaafar", addEmployeePage.lastNameloc);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //  WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        click(addEmployeePage.saveButton);
    }

    @Then("employee is added succesfully")
    public void employee_is_added_succesfully() {
        String query = "select emp_firstname, emp_middle_name, emp_lastname \n" +
                "from hs_hr_employee where employee_id='" + autoEmployeeId + "'";
        List<Map<String, String>> dataBE = DBUtils.fetch(query);
        String firstNameBE=dataBE.get(0).get("emp_firstname");
        String middleNameBE=dataBE.get(0).get("emp_middle_name");
        String lastNameBE=dataBE.get(0).get("emp_lastname");

        Assert.assertEquals(firstNameFE,firstNameBE);
        Assert.assertEquals(middleNameFE,middleNameBE);
        Assert.assertEquals(lastNameFE,lastNameBE);


    }

    @When("user enters {string} {string} and {string} values")
    public void user_enters_and_values(String firstname, String middlename, String lastname) throws InterruptedException {
        Thread.sleep(1000);
        WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        sendText(firstname, firstNameloc);

        Thread.sleep(1000);
        WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        sendText(middlename, middleNameloc);

        Thread.sleep(1000);
        WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        sendText(lastname, lastNameloc);

        firstNameFE = firstname;
        middleNameFE = middlename;
        lastNameFE = lastname;
        autoEmployeeId = addEmployeePage.employeeID.getAttribute("value");
    }

    @When("user enters {string} {string} and {string} field values")
    public void user_enters_and_field_values(String firstname, String middlename, String lastname) throws InterruptedException {
        Thread.sleep(1000);
        WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        sendText(firstname, firstNameloc);

        Thread.sleep(1000);
        WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        sendText(middlename, middleNameloc);

        Thread.sleep(1000);
        WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        sendText(lastname, lastNameloc);
    }

    @When("user enters firstname and middlename and lastname field values")
    public void user_enters_firstname_and_middlename_and_lastname_field_values
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee : employeeNames) {

            //reading the values based on the keys and fill it in the fields
            Thread.sleep(1000);
            WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
            sendText(employee.get("firstname"), firstNameloc);

            Thread.sleep(1000);
            WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
            sendText(employee.get("middlename"), middleNameloc);

            Thread.sleep(1000);
            WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
            sendText(employee.get("lastname"), lastNameloc);

            WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
            click(saveButton);

            Thread.sleep(1000);
            WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            click(addEmpOption);
        }

    }

    @When("user enters firstname and middlename and lastname field values using excel and verify them")
    public void user_enters_firstname_and_middlename_and_lastname_field_values_using_excel_and_verify_them() throws IOException, InterruptedException {
        List<Map<String, String>> newEmployees = ExcelReader.read();
        for (Map<String, String> employee : newEmployees) {

            //reading the values based on the keys and fill it in the fields
            Thread.sleep(1000);
            WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
            sendText(employee.get("firstName"), firstNameloc);

            Thread.sleep(1000);
            WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
            sendText(employee.get("middleName"), middleNameloc);

            Thread.sleep(1000);
            WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
            sendText(employee.get("lastName"), lastNameloc);

            WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
            click(saveButton);

            Thread.sleep(1000);
            WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            click(addEmpOption);
        }

    }

}
