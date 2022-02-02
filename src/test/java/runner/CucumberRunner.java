package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\feature\\Login.feature"},//path of feature file
glue = {"stepDefinitions"},//package name
dryRun = false,// when it is true it will map both feature and step definition for missing steps
//tags = "@fast",
plugin = {"pretty",
		"html:report/cucumberreport.html",
		"json:report/cucumberjson.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},//used to print the feature file step during execution
monochrome = true)//remove the special character in console o/p
public class CucumberRunner extends AbstractTestNGCucumberTests{
/*
 *  @SmokeTest and @Regression:- if scenario having both the tags it will invoke the scenario
 *  @SmokeTest or @Regression: if scenario is having any one of the tag it will invoke for execution
 *  not @SmokeTest: exclude that specific tag in scenario
 */
}
