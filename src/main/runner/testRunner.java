package main.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features="src/features",
		glue= {"main/testDefinitions"}
		/*,tags= {"@Before","@URL&form"}*/
		)

public class testRunner {

}