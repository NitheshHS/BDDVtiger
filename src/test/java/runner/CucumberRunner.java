package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\feature"},//path of feature file
glue = {"stepDefinitions"},//package name
dryRun = true)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
