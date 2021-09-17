import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {"src/test/java/features/Register.feature"},
        //features = {"src/test/java/features/CommunityPoll.feature"},
        //features = {"src/test/java/features/Login.feature"},
        //features = {"src/test/java/features/AddToCart.feature"},

        features = {"src/test/java/features/"},
        tags = "@ui",
        //tags = "@NegativeTest or @EndToEnd",          //to run scenarios which has either of the tags
        //tags = "@NegativeTest and @EndToEnd",         //to run scenarios which has all tags


        //glue = {"steps"},                             //describes the location and path of the step definition file
        //dryRun = true,                                //checks for any feature is not implemented in step definitions
        //monochrome = true,                            //Console output is cleaner for better understanding


        plugin = {"pretty","html:target/report.html"}
)

public class TestRunner
{
}
