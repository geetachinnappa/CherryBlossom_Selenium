package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

public class BasePage
{
    public static WebDriver driver;

    public static HomePage homePage;
    public static CommunityPollPage communityPollPage;
    public static RegisterPage registerPage;
    public static LoginPage loginPage;
    public static SearchPage searchPage;
    public static ShoppingCart shoppingCart;


    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        communityPollPage = new CommunityPollPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @After
    public void closeUp(Scenario scenario)
    {

        if(scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "errorScreenshot");
        }

        driver.quit();

    }


    public static void navigateToUrl(String url)
    {
        driver.navigate().to(url);
    }

    public static String getPageTitle()
    {
        return driver.getTitle();
    }

}
