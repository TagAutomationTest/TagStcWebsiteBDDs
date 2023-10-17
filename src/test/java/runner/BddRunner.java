package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features", glue = {"Steps"}, monochrome = true, plugin = {
"pretty", "html:test-output", "json:target/cucumber-report/cucumber.json",
   "rerun:target/cucumber-reports/rerun.txt"},  tags=("not @ignore and @test"))
//[cucumber.ansi-colors.disabled, cucumber.execution.dry-run, cucumber.execution.limit, cucumber.execution.order, cucumber.execution.strict, cucumber.execution.wip, cucumber.features, cucumber.filter.name, cucumber.filter.tags, cucumber.glue, cucumber.object-factory, cucumber.plugin, cucumber.snippet-type]
public class BddRunner {
	
}
