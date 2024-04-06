package orangehrm.pageobjects;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class Admin_AddUsersPage extends ResuableComponents {

	WebDriver driver;
	public Admin_AddUsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	//List<WebElement> fieldLabels = driver.findElements(By.xpath("//label[contains(@class,'oxd-label')]"));
	@FindBy(xpath="//label[contains(@class,'oxd-label')]")
	List <WebElement> fieldLabels;
	
//	driver.findElement(By.cssSelector(".oxd-select-dropdown"))
	@FindBy(css = ".oxd-select-dropdown")
	WebElement statusDropdown;
	
//	driver.findElement(By.cssSelector(".oxd-select-option:last-child"))
	@FindBy(css=".oxd-select-option span")
	List<WebElement> userRoleList;
	
//	driver.findElements(By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]/div/span"))
	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-dropdown')]/div/span")
	List<WebElement> empNameDropdown;
	
//	driver.findElements(By.cssSelector(".oxd-select-option span"));
	@FindBy(css=".oxd-select-option span")
	List<WebElement> statusList;
	
//	driver.findElement(By.xpath("//button[@type=\"submit\"]"))
//	@FindBy(xpath = "//button[@type=\"submit\"]")
//	WebElement submitButton;
//	
	public void userInfo(String userRoleToBeSelected, String empName, String defaultStatus, String userName, String pass) {
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("User Role")).findFirst().ifPresent(label->
		{
			driver.findElement(with(By.tagName("div")).below(label)).click();
//			List<WebElement> userRoleList = driver.findElements(By.cssSelector(".oxd-select-option span"));
			userRoleList.stream().filter(userRole -> userRole.getText().equalsIgnoreCase(userRoleToBeSelected)).findAny().ifPresentOrElse(userRole->userRole.click(), null);
		});
		
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("Employee Name")).findFirst().ifPresent(label->
		{
		
			WebElement empNameInputField =  driver.findElement(with(By.tagName("input")).below(label));
			empNameInputField.sendKeys(empName);
//			List<WebElement> empNameDropdown = driver.findElements(By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]/div/span"));
//			wait.until(ExpectedConditions.visibilityOfAllElements(empNameDropdown));
			waitForAllWebElementToAppear(empNameDropdown);
			empNameDropdown.stream().filter(eName -> eName.getText().contains(empName)).findAny().ifPresentOrElse(suggestion->suggestion.click(), null);
		});
		
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("Status")).findFirst().ifPresent(label->
		{
//			String defaultStatus = "Enabled";
			driver.findElement(with(By.tagName("div")).below(label)).click();
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".oxd-select-dropdown"))));
			waitForWebElementToAppear(statusDropdown);
//			List<WebElement> statusList = driver.findElements(By.cssSelector(".oxd-select-option span"));
			statusList.stream().filter(status->status.getText().equalsIgnoreCase(defaultStatus)).findAny().ifPresentOrElse(status->status.click(), null);
		});	
		
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("Username")).findAny().ifPresent(label-> driver.findElement(with(By.tagName("input")).below(label)).sendKeys(userName));
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("Password")).findAny().ifPresent(label-> driver.findElement(with(By.tagName("input")).below(label)).sendKeys(pass));
		fieldLabels.stream().filter(label->label.getText().equalsIgnoreCase("Confirm Password")).findAny().ifPresent(label-> driver.findElement(with(By.tagName("input")).below(label)).sendKeys(pass));
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		saveButton();
//		submitButton.click();
	}


}

