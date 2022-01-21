package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(



        features = "features/main.feature",

        glue = "steps",
        dryRun = false
)
public class CucumberTestrunner {
}
