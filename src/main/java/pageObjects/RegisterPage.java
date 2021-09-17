package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage
{
    WebDriver driver;

    String successActualMsg;

    @FindBy (id = "gender-male")
    public WebElement genderMale;

    @FindBy (id = "gender-female")
    public WebElement genderFemale;

    @FindBy (name = "FirstName")
    public WebElement firstName;

    @FindBy (id = "LastName")
    public WebElement lastName;

    @FindBy (name = "DateOfBirthDay")
    public WebElement dayDOB;

    @FindBy (name = "DateOfBirthMonth")
    public WebElement monthDOB;

    @FindBy (name = "DateOfBirthYear")
    public WebElement yearDOB;

    @FindBy (id = "Email")
    public WebElement eMail;

    @FindBy (id = "Company")
    public WebElement companyName;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy (id = "register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement successMessage;

    //Required field Error Message Web elements

    @FindBy (id = "FirstName-error")
    public WebElement firstNameError;

    @FindBy (id = "LastName-error")
    public WebElement lastNameError;

    @FindBy (id = "Email-error")
    public WebElement eMailError;

    @FindBy (id = "Password-error")
    public WebElement passwordError;

    @FindBy (id = "ConfirmPassword-error")
    public WebElement confirmPasswordError;


    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectGender(String gender)
    {
        if(gender.equals("M"))
            genderMale.click();
        else if(gender.equals("F"))
            genderFemale.click();
    }

    public void enterFirstName(String fName)
    {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName)
    {
        lastName.sendKeys(lName);
    }

    public void enterEMail(String eMailID)
    {
        eMail.sendKeys(eMailID);
    }

    public void selectDay(String day)
    {
        Select selectDay = new Select(dayDOB);
        selectDay.selectByValue(day);
    }

    public void selectMonth(String month)
    {
        Select selectMonth = new Select(monthDOB);
        selectMonth.selectByValue(month);
    }

    public void selectYear(String year)
    {
        Select selectYear = new Select(yearDOB);
        selectYear.selectByValue(year);
    }

    public void enterCompanyName(String compName)
    {
        if(compName != null)
            companyName.sendKeys(compName);
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd)
    {
        confirmPassword.sendKeys(cpwd);
    }


    public void clickRegisterButton()
    {
        registerButton.click();
    }

    public String validateSuccessReg()
    {
       successActualMsg = successMessage.getText();
       return successActualMsg;

    }

    public void validateErrorMessages()
    {
        Assertions.assertEquals("First name is required.", firstNameError.getText());
        Assertions.assertEquals("Last name is required.", lastNameError.getText());
        Assertions.assertEquals("Email is required.", eMailError.getText());
        Assertions.assertEquals("Password is required.", passwordError.getText());
        Assertions.assertEquals("Password is required.", confirmPasswordError.getText());

    }



}
