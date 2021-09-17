package pageObjects;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    @FindBy(id = "Email")
    public WebElement eMail;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (className = "login-button")
    public WebElement loginButton;


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email)
    {
        eMail.sendKeys(email);
    }

    public void enterPassword(String pword)
    {
        password.sendKeys(pword);
    }

    public void clickLoginBtn()
    {
        loginButton.click();
    }

    public void validateLogin()
    {
        boolean validateLogout = BasePage.homePage.logOutLink.isDisplayed();
        Assertions.assertTrue(validateLogout, "Validating if Login was successful by checking Logout link is present in Nav bar");

        BasePage.homePage.clickLogoutLink();
    }

}
