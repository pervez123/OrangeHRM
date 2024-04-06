package orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class LoginPage extends ResuableComponents {

	// class variable
	WebDriver driver;
	
	// constructor
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	// Locating webElements using Page Factory
	
	@FindBy(css=".orangehrm-demo-credentials p:first-child")
	public
	WebElement username;
	
	@FindBy(css=".orangehrm-demo-credentials p:last-child")
	public
	WebElement password;
	
	@FindBy(name="username")
	WebElement unameInputField;
	
	@FindBy(name="password")
	WebElement passInputField;
	
	@FindBy(css=".orangehrm-login-button")
	WebElement loginButton;
	
	@FindBy(css=".oxd-alert-content-text")
	WebElement errorAlert;
	
	public DashboardPage login(String vUsername, String vPassword) {
		
		unameInputField.sendKeys(vUsername);
		passInputField.sendKeys(vPassword);
		loginButton.click();
		DashboardPage dp = new DashboardPage(driver);
		return dp;
		
	}
	
	public String getErrorAlert() {
		return errorAlert.getText();
	}
	
	public void launchApp() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
}
