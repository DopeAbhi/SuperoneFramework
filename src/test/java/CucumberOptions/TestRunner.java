package CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= {"src/test/java/Feature/Login.feature","src/test/java/Feature/Signup.feature","src/test/java/Feature/Transfer.feature"},
        plugin = {"pretty","html:target/cucumber-reports/reports.html"},
         glue="stepDefination"
)
public class TestRunner {

}
