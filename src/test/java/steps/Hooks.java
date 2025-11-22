package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //pre condition
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }


    //post condition
    @After
    public void end(Scenario scenario){
        //scenarios class in cucumber holds the complete information about your execution i.e test case name, time etc.

        byte[] pic;

        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        closeBrowser();
    }


}
