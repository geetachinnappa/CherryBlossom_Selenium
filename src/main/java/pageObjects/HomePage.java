package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(linkText = "Log in")
    public WebElement logInLink;

    @FindBy (className = "ico-logout")
    public WebElement logOutLink;

    @FindBy (id = "small-searchterms")
    public WebElement searchItem;

    @FindBy (className = "search-box-button")
    public WebElement searchButton;

    @FindBy (partialLinkText = "Shopping cart")
    public WebElement shoppingLink;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickRegisterLink()
    {
        registerLink.click();
    }

    public void clickLoginLink()
    {
        logInLink.click();
    }

    public void clickLogoutLink()
    {
        logOutLink.click();
    }

    public void enterSearchItem(String item)
    {
        searchItem.sendKeys(item);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void clickGoToCart()
    {
        shoppingLink.click();
    }

}
