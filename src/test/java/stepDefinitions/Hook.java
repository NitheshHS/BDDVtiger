package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PageFactoryManager;
import utility.Base;
import utility.FileUtility;
import utility.WebDriverUtility;

public class Hook {
	Base base;//global variable
	FileUtility fileUtility=new FileUtility();
	public Hook(Base base) {
		this.base=base;
	}
	@Before
	public void initBrowser() throws Throwable {
		String browser=fileUtility.getPropertyValue("browserName");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}else {
			System.out.println("invalid browser name: "+browser);
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		base.driver.get(fileUtility.getPropertyValue("url"));
		//initialize the page factory manager
		base.pages=new PageFactoryManager(base.driver);
	}
	
	@After
	public void quitBrowser(Scenario scenario) {
		if(scenario.isFailed()) {
			WebDriverUtility.getScreenshot(base.driver, scenario.getName());
			scenario.attach(WebDriverUtility.getScreenshotInBytes(base.driver), 
					"image/png", scenario.getName());
		}
		base.driver.close();
	}
	//before annotation will execute in ascending order means lower to higher values
//	@Before(order = 0)
//	public void configDB() {
//		System.out.println("Connect to database");
//	}
//	
//	@Before(order = 2)
//	public void login() {
//		System.out.println("Logging to application");
//	}
	
	
	//exceute in descending order means higher to lower
	
	
//	@After(order=0)
//	public void closeDB() {
//		System.out.println("closing DB connection");
//	}
//	
//	@After(order=2)
//	public void logOut() {
//		System.out.println("logout from app");
//	}

}
