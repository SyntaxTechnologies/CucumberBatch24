package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the feature directory
        features = "@target/failed.txt",
        //path of the steps package, name must be same
        glue = "steps"
        //when you set the value of dry run to true, it stops execution and scans all the step def
        //and provide missing step definition, to execute the test case, set the value to false
     //   dryRun = false,
        //tags = "@sprint1 or @sprint2"
        //tags = "@sprint1 and @sprint2"
       // tags = "@sprint22",
        //pretty - it prints all the steps in console, so that you can check which is failing with links
       // plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
         //       "rerun:target/failed.txt"}
        //rerun plugin creates the file having the path of only failed test cases
)

public class FailedRunner {
}
