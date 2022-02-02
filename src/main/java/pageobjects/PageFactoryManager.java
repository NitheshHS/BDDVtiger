package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
	WebDriver driver;//null // obj will created in hook class
	public PageFactoryManager(WebDriver driver) {
		this.driver=driver;
	}
	private LoginPage loginPage;
	private HomePage homePage;
	public LoginPage initLoginPage() {
		return loginPage==null?loginPage=new LoginPage(driver):loginPage;
	}
	public HomePage initHomePage() {
		return homePage==null?homePage=new HomePage(driver):homePage;
	}

}
