package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	WebDriver driver;
	@Given("I will launch {string} browser")
	public void i_will_launch_browser(String browser) {
	  if(browser.equals("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }else if(browser.equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  else {
		  System.out.println("Browser name is not valid: "+browser);
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("I will enter the url {string}")
	public void i_will_enter_the_url(String url) {
	    driver.get(url);
	}
	@When("login page is displayed I will enter username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@When("I Will click on login")
	public void i_will_click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	@Then("I will validate Home page title")
	public void i_will_validate_home_page_title() {
	    System.out.println(driver.getTitle());
	    driver.quit();
	}
	
	@When("Home page is displayed click on organization")
	public void home_page_is_displayed_click_on_organization() {
	    driver.findElement(By.linkText("Organizations")).click();
	}
	@When("click on create new organization image link")
	public void click_on_create_new_organization_image_link() {
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	@When("enter the organization name {string} and select industry drop down {string}")
	public void enter_the_organization_name_and_select_industry_drop_down(String orgName, String industryType) {
	  Random random=new Random();
		driver.findElement(By.name("accountname")).sendKeys(orgName+random.nextInt());
	  Select sel=new Select(driver.findElement(By.name("industry")));
	  sel.selectByValue(industryType);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("validate organization is created or not {string}")
	public void validate_organization_is_created_or_not(String orgnaziation) {
	   String orgName= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   Assert.assertTrue(orgName.contains(orgnaziation));
	   driver.quit();
	}
	
	@When("I want read a data form below data table")
	public void i_want_read_a_data_form_below_data_table(io.cucumber.datatable.DataTable dataTable) {
	  List<List<String>> data = dataTable.asLists();
	  System.out.println(data);
	  System.out.println(data.get(0).get(0));
	  System.out.println(data.get(2).get(2));
	}


}
