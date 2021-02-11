package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // feature file will read my feature files
        glue = "com/cybertek/step_definitions",
        dryRun = false // once it true -> allows just to run and get the Snippets, before running actual Test
                      // once its false -> it's turned ON and allows us to run actual codes.
)
public class CukesRunner {


}
