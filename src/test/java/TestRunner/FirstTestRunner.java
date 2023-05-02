package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
            features = {"src/main/resources/Features/postPageUseCases.feature"},
            glue={"StepDefinitions","AppHooks"},
            tags="",
            plugin = { "pretty","html:target/cucumber-reports.html"}
    )

public class FirstTestRunner{

}

