package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features", glue = {"Steps"}, monochrome = true, plugin = {
        "pretty", "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt"},  tags=("not @ignore and @Validation"))
public class BddRunner {
	
}
