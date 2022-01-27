package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "features/editproduct.feature",

        glue = "steps",
        dryRun = true
)
public class CucumberTestrunner {
}
