package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
    WebDriver driver;

    public String productName;

    @FindBy(xpath = "((//button[text()='Add to cart'])[1])")
    public WebElement addToCartButton;

    @FindBy(xpath = "//p[contains(text(),'added')]")
    public WebElement itemAddNotification;

    @FindBy(className = "close")
    public WebElement closeNotificationBar;

    @FindBy(xpath = "(//h2[@class='product-title'])[1]")
    public WebElement firstProductName;


    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int findNumOfAddToCartButtons()
    {
        int noOfAddToCart = driver.findElements(By.xpath("(//button[text()='Add to cart'])")).size();
        return noOfAddToCart;
    }

    public void clickAddToCart()
    {
        productName = firstProductName.getText();
        addToCartButton.click();
    }

    public String getAddNotification()
    {
        String message = itemAddNotification.getText();
        closeNotificationBar.click();  //Click on X on notification bar
        return message;
    }

    public String getProductName()
    {
        return productName;
    }




}
