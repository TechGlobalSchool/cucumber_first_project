package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Regression",
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json"
        },
        monochrome = true,
        dryRun = false
)

public class Runner {
}
