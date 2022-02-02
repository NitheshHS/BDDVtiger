package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") 
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	@FindBy(xpath="//div[@class='errorMessage']")
	private WebElement errorMessage;
	
	
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public void setUserNameTextField(WebElement userNameTextField) {
		this.userNameTextField = userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	
	

}
