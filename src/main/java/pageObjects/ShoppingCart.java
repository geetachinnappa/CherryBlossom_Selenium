package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart
{
    WebDriver driver;

    @FindBy (css = "a.product-name")
    public WebElement productName;

    public ShoppingCart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getProductName()
    {
        return productName.getText();
    }

}
