package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\feature\\DataDriven.feature"},//path of feature file
glue = {"stepDefinitions"},//package name
dryRun = false)// when it is true it will map both feature and step definition for missing steps
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
