package CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= {"src/test/java/Feature/Signup.feature"},
        plugin = {"pretty","html:target/cucumber-reports/reports.html"},
         glue="stepDefination"
)
public class TestRunner {

}
