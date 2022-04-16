package com.cydeo.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(


        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"



        },

        glue = "com/cydeo/library/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@wip",
        publish = true

)




public class CukesRunner {





}
