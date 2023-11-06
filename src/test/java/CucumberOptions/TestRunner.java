package CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/java/Feature/Login.feature",
        plugin = "json:target/jsonReports/cucumber-report.json",
         glue="stepDefination"
)
public class TestRunner {

}
