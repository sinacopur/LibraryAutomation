package com.cydeo.library.step_definitions;


import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DB_Utilities;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpUI(){

        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

    }



//    @Before
//    public void setUpDB() {
//
//       DB_Utilities.createConnection(ConfigurationReader.getProperty("JDBC_URL"),
//                ConfigurationReader.getProperty("DB_username"),
//              ConfigurationReader.getProperty("DB_password"));
//
//    }

    @After
    public void screenShot(Scenario scenario){

        if (scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        Driver.closeDriver();

    }

    @After
    public void destroyDB() {

        DB_Utilities.destroy();


    }


}
