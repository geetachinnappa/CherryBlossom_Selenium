import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepDefinitions
{
    WebDriverWait wait;

    @Given("User navigates to url {string}")
    public void user_navigates_to_url(String url)
    {
        BasePage.navigateToUrl(url);
    }

    @Then("User should be navigated to home page {string}")
    public void user_should_be_navigated_to_home_page(String homePageExpectedTitle)
    {
        String homePageActualTitle = BasePage.getPageTitle();
        Assertions.assertEquals(homePageExpectedTitle,homePageActualTitle);
    }

    /** Community Poll Step Definitions - Start here */

    @When("User selects any of the radio button {string}")
    public void user_selects_any_of_the_radio_button(String selectedRadioBtn)
    {
        if(selectedRadioBtn.equals("1"))
        {
            BasePage.communityPollPage.selectExcellent();
        }
        else if(selectedRadioBtn.equals("2"))
        {
            BasePage.communityPollPage.selectGood();
        }
        else if(selectedRadioBtn.equals("3"))
        {
            BasePage.communityPollPage.selectBad();
        }
        else if(selectedRadioBtn.equals("4"))
        {
            BasePage.communityPollPage.selectVeryBad();
        }
    }

    @When("User clicks on the Vote button")
    public void user_clicks_on_the_vote_button() throws NoSuchElementException
    {
        try
        {
            BasePage.communityPollPage.clickVote();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String pollExpectedErrorMessage)
    {
        wait = new WebDriverWait(BasePage.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(BasePage.communityPollPage.pollErrorMessage));

        String pollActualErrorMessage = BasePage.communityPollPage.getPollError();
        Assertions.assertEquals(pollExpectedErrorMessage, pollActualErrorMessage);
    }

    @Then("User should see an alert message - please select an answer")
    public void user_should_see_an_alert_message_please_select_an_answer()
    {
        String pollExpAlert = "Please select an answer";
        String pollActAlert = BasePage.communityPollPage.getPollVoteAlert();
        Assertions.assertEquals(pollExpAlert,pollActAlert);
    }

    @Then("User should see an alert message - {string}")
    public void userShouldSeeAnAlertMessage(String pollExpAlert)
    {
        String pollActAlert = BasePage.communityPollPage.getPollVoteAlert();
        Assertions.assertEquals(pollExpAlert,pollActAlert);
    }

    @Then("User should see total number of votes for all the choices")
    public void user_should_see_total_number_of_votes_for_all_the_choices()
    {
        wait = new WebDriverWait(BasePage.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(BasePage.communityPollPage.pollResults));

        System.out.println(BasePage.communityPollPage.getPollResults());
    }

    /** Community Poll Step Definitions - Ends here */



    /** Register Step Definitions - Starts here */

    String registerPageActualTitle;

    @When("User clicks on Register link on the Navigation bar")
    public void user_clicks_on_register_link_on_the_navigation_bar()
    {
        BasePage.homePage.clickRegisterLink();
    }

    @Then("User should be navigated to Register page {string}")
    public void user_should_be_navigated_to_register_page(String registerPageExpectedTitle)
    {
        registerPageActualTitle = BasePage.getPageTitle();
        Assertions.assertEquals(registerPageExpectedTitle,registerPageActualTitle);
    }

    @When("User Clicks on Register button")
    public void user_clicks_on_register_button()
    {
        BasePage.registerPage.clickRegisterButton();
    }

    @Then("User should be prompted to enter the required fields to Register")
    public void user_should_be_prompted_to_enter_the_required_fields_to_register()
    {
        BasePage.registerPage.validateErrorMessages();
    }

    @When("User enters gender firstName lastName day month year eMail companyName password confirmPassword")
    public void user_enters_gender_first_name_last_name_day_month_year_e_mail_company_name_password_confirm_password(io.cucumber.datatable.DataTable dataTable)
    {
        BasePage.registerPage.selectGender(dataTable.cell(1,0));
        BasePage.registerPage.enterFirstName(dataTable.cell(1,1));
        BasePage.registerPage.enterLastName(dataTable.cell(1,2));
        BasePage.registerPage.selectDay(dataTable.cell(1,3));
        BasePage.registerPage.selectMonth(dataTable.cell(1,4));
        BasePage.registerPage.selectYear(dataTable.cell(1,5));
        BasePage.registerPage.enterEMail(dataTable.cell(1,6));
        BasePage.registerPage.enterCompanyName(dataTable.cell(1,7));
        BasePage.registerPage.enterPassword(dataTable.cell(1,8));
        BasePage.registerPage.enterConfirmPassword(dataTable.cell(1,9));
    }


    @Then("User should see message {string}")
    public void user_should_see_message(String successExpectedMsg)
    {
        String successActualMsg = BasePage.registerPage.validateSuccessReg();
        Assertions.assertEquals(successExpectedMsg, successActualMsg);

        BasePage.homePage.clickLogoutLink();
    }

    /** Register Step Definitions - Ends here */



    /** Login Step Definitions - Start here */

    @When("User clicks on Log in link on the Navigation bar")
    public void user_clicks_on_log_in_link_on_the_navigation_bar()
    {
        BasePage.homePage.clickLoginLink();
    }

    @Then("User should be navigated to login page {string}")
    public void user_should_be_navigated_to_login_page(String loginPageExpectedTitle)
    {
        String loginPageActualTitle = BasePage.getPageTitle();
        Assertions.assertEquals(loginPageExpectedTitle,loginPageActualTitle);
    }

    @When("User enters email {string}")
    public void user_enters_email(String email)
    {
        BasePage.loginPage.enterEmail(email);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password)
    {
        BasePage.loginPage.enterPassword(password);
    }


    @When("User clicks on log in button")
    public void user_clicks_on_log_in_button()
    {
        BasePage.loginPage.clickLoginBtn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully()
    {
        BasePage.loginPage.validateLogin();
    }


    /** Login Step Definitions - Ends here */


    /** Search and Add to Cart Step Definitions - Starts here */

    @When("User enters search item {string} into Search textbox in Home page")
    public void user_enters_search_item_into_search_textbox_in_home_page(String item)
    {
        BasePage.homePage.enterSearchItem(item);
    }

    @When("User clicks on Search Store button")
    public void user_clicks_on_search_store_button()
    {
        BasePage.homePage.clickSearchButton();
    }

    @Then("User should be navigated to search page {string}")
    public void user_should_be_navigated_to_search_page(String searchPageExpectedTitle)
    {
        String searchPageActualTitle = BasePage.getPageTitle();
        Assertions.assertEquals(searchPageExpectedTitle,searchPageActualTitle);
    }

    @When("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button()
    {
        int totalButton = BasePage.searchPage.findNumOfAddToCartButtons();

        if (totalButton >= 1)
        {
            BasePage.searchPage.clickAddToCart();
        }
        WebDriverWait wait = new WebDriverWait(BasePage.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(BasePage.searchPage.itemAddNotification));
    }

    @Then("User should see {string} message on notification bar")
    public void user_should_see_message_on_notification_bar(String expectedMessage)
    {
        String actualMessage = BasePage.searchPage.getAddNotification();
        Assertions.assertEquals(expectedMessage,actualMessage);
    }

    @When("User clicks on Shopping cart link on the Navigation bar")
    public void user_clicks_on_shopping_cart_link_on_the_navigation_bar()
    {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(BasePage.homePage.shoppingLink));

        BasePage.homePage.clickGoToCart();
    }

    @Then("User should be navigated to Shopping Cart page {string}")
    public void user_should_be_navigated_to_shopping_cart_page(String shoppingCartExpectedTitle)
    {
        String shoppingCartActualTitle = BasePage.getPageTitle();
        Assertions.assertEquals(shoppingCartExpectedTitle,shoppingCartActualTitle);

        String productAdded = BasePage.searchPage.getProductName();
        String productAddedInCart = BasePage.shoppingCart.getProductName();

        //Validate product added and product in cart are same
        Assertions.assertEquals(productAdded,productAddedInCart);
    }

    /** Search and Add to Cart Step Definitions - Ends here */




}
