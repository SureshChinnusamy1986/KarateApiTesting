package apiTest;

import org.junit.runner.*;

//import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit5.Karate;

import cucumber.api.CucumberOptions;


public class TestRunner {
	@Karate.Test
	Karate sample() {
		return Karate.run("ApiScenario").relativeTo(getClass());
    
}}
