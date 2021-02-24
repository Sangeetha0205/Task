import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"},
        glue = {"com.accenture.testing.bdd.api.steps"}
)
public class RunCucumberTest {

}