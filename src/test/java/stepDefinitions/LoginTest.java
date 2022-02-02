package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import pageobjects.PageFactoryManager;
import utility.Base; 


public class LoginTest {
	
	Base base;
	
	public LoginTest(Base base) {
		this.base=base;
	}
	
	

	@When("Login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
//	  base.driver.findElement(By.name("user_name")).sendKeys("admin");
//	  base.driver.findElement(By.name("user_password")).sendKeys("manager");
	base.pages.initLoginPage().getUserNameTextField().sendKeys("admin");
	base.pages.initLoginPage().getPasswordTextField().sendKeys("manager");
	}

	@When("click on login")
	public void click_on_login() {
//	    base.driver.findElement(By.id("submitButton")).click();
		base.pages.initLoginPage().getLoginButton().click();
	}

	@Then("validate the home page is displayed or not")
	public void validate_the_home_page_is_displayed_or_not() {
	   String title=base.driver.getTitle();
	   Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	   
	}

	@When("login page is displayed enter invalid username and password")
	public void login_page_is_displayed_enter_invalid_username_and_password() {
//		  base.driver.findElement(By.name("user_name")).sendKeys("admin123");
//		  base.driver.findElement(By.name("user_password")).sendKeys("manager123");
		base.pages.initLoginPage().getUserNameTextField().sendKeys("admin123");
		base.pages.initLoginPage().getPasswordTextField().sendKeys("password");
	}

	@Then("error message should display")
	public void error_message_should_display() {
		//String errorMsg=base.driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	  String errorMsg= base.pages.initLoginPage().getErrorMessage().getText();
		Assert.assertEquals(errorMsg, "You must specify a valid username and password.");
	    
	}
}
