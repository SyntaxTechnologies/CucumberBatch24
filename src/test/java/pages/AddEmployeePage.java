package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameloc;

    @FindBy(xpath = "//*[@name='middleName']")
    public WebElement middleNameloc;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameloc;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
