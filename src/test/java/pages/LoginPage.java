package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement errorMessageLoc;


    public LoginPage(){
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver,this);
    }

}
