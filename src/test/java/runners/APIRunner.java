package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the feature directory
        features = "src/test/resources/features/",
        //path of the steps package, name must be same
        glue = "APISteps",
        //when you set the value of dry run to true, it stops execution and scans all the step def
        //and provide missing step definition, to execute the test case, set the value to false
        dryRun = true,
        //tags = "@sprint1 or @sprint2"
        //tags = "@sprint1 and @sprint2"
        tags = "@api2",
        //pretty - it prints all the steps in console, so that you can check which is failing with links
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)

public class APIRunner {
}
