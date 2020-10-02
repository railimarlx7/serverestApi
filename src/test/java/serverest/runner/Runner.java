package serverest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		   tags = {"@serverest"},
		   features = "src/test/features",
	       glue = {"stepdefinition"},
	       plugin = {"pretty"},
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			dryRun = false,
			strict = true
			)
		public class Runner {
		  
	
	

	}