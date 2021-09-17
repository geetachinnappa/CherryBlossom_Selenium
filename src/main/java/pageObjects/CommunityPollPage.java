package pageObjects;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityPollPage {
    WebDriver driver;
    WebDriverWait wait;

    //Community Poll Web elements on Homepage
    @FindBy(css = ".answer:nth-of-type(1)")
    public WebElement excellentRadioButton;

    @FindBy(css = ".answer:nth-of-type(2)")
    public WebElement goodRadioButton;

    @FindBy(css = ".answer:nth-of-type(3)")
    public WebElement badRadioButton;

    @FindBy(css = ".answer:nth-of-type(4)")
    public WebElement veryBadRadioButton;

    @FindBy(id = "vote-poll-1")
    public WebElement voteButton;

    @FindBy(css = "div.poll-vote-error")
    public WebElement pollErrorMessage;

    @FindBy(className = "poll-results")
    public WebElement pollResults;


    public CommunityPollPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectExcellent() {
        excellentRadioButton.click();
    }

    public void selectGood() {
        goodRadioButton.click();
    }

    public void selectBad() {
        badRadioButton.click();
    }

    public void selectVeryBad() {
        veryBadRadioButton.click();
    }

    public void clickVote()
    {
            voteButton.click();
    }

    public String getPollError()
    {
        return pollErrorMessage.getText();
    }

    public String getPollVoteAlert()
    {
        return driver.switchTo().alert().getText();
    }

    public String getPollResults()
    {
        return pollResults.getText();
    }

}
