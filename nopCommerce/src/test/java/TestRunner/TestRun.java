package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features/nopCustomer.feature",
                   glue = "StepDefinitions",
                   dryRun = false,
                   monochrome = true,
                   tags = "@sanity",
                   plugin= {"pretty","html:test-output"})

public class TestRun {

}
