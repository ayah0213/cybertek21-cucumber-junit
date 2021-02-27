package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",//generate Json type of file,
                  // where the result of of the running of our project will be stored in JSON format
                //We will use this file(cucumber.json)with a 3rd party tool which
                // will be reading this file and generate more understandable report

                "rerun:target/rerun.txt"// this plugin will allow us to store failed tests in a .txt file
                // we will have 2nd runner class which will be reading from this running only fails tests
        },
        features = "src/test/resources/features",  // feature file will read my feature files
        glue = "com/cybertek/step_definitions",
        dryRun = false,        // once it true -> allows just to run and get the Snippets, before running actual Test
                               // once its false -> it's turned ON and allows us to run actual codes tests
        tags = ""
)
public class CukesRunner {


}
