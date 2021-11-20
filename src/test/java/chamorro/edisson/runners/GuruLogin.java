package chamorro.edisson.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "chamorro.edisson.stepdefinitions",
		features = "src/test/resources/chamorro/edisson/features/guru_login.feature",
		snippets = SnippetType.CAMELCASE
		)

public class GuruLogin { 

} 
