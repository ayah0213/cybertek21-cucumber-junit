package com.cybertek.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void seTupScenario(){
        System.out.println("---------Setting up browser with futher details...");
    }

    @Before

    @After
    public void tearDownScenario(){
        System.out.println("-------------Take a screenshot");
        System.out.println("-------------Closing browser and ");
    }
}
