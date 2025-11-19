package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //pre condition
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }


    //post condition
    @After
    public void end(){
        closeBrowser();
    }


}
