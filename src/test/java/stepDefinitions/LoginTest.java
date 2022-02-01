package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Given("I will launch browser")
	public void i_will_launch_browser() {
	    WebDriverManager.chromedriver().setup();//act as system.setProperty method
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Given("I will enter the url")
	public void i_will_enter_the_url() {
	   driver.get("http://localhost:8888/");
	}

	@When("Login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	  driver.findElement(By.name("user_name")).sendKeys("admin");
	  driver.findElement(By.name("user_password")).sendKeys("manager");
	}

	@When("click on login")
	public void click_on_login() {
	    driver.findElement(By.id("submitButton")).click();
	}

	@Then("validate the home page is displayed or not")
	public void validate_the_home_page_is_displayed_or_not() {
	   String title=driver.getTitle();
	   Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	   driver.quit();
	}

	@When("login page is displayed enter invalid username and password")
	public void login_page_is_displayed_enter_invalid_username_and_password() {
		  driver.findElement(By.name("user_name")).sendKeys("admin123");
		  driver.findElement(By.name("user_password")).sendKeys("manager123");
	}

	@Then("error message should display")
	public void error_message_should_display() {
	    String errorMsg=driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	    Assert.assertEquals(errorMsg, "You must specify a valid username and password.");
	    driver.quit();
	}
}
