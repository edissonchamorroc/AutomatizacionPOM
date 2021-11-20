package com.sophossolutions.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.sophossolutions.steps",
        features = "src/test/resources/com/sophossolutions/features/advantage_demo_shopping.feature",
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false
)
public class AdvantageDemoShopping {

}
