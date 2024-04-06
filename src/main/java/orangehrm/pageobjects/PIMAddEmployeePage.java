package orangehrm.pageobjects;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class PIMAddEmployeePage extends ResuableComponents {

	WebDriver driver;
	
	@FindBy(name = "firstName")
	WebElement empFirstName;

	@FindBy(name = "middleName")
	WebElement empMidName;

	@FindBy(name = "lastName")
	WebElement empLastName;

	@FindBy(xpath="//label[@class='oxd-label']/parent::div/following-sibling::div/input")
	WebElement empId;

	@FindBy(css = ".employee-image-action")
	WebElement empImage;
	

	public PIMAddEmployeePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String addEmp(String fName, String midName, String lName, String eId, String filePath) throws AWTException {
		empFirstName.sendKeys(fName);
		empMidName.sendKeys(midName);
		empLastName.sendKeys(lName);
		uploadFile(empImage, filePath);
		waitForWebElementToAppear(empId);
		empId.clear(); // need to check why field is not clearing
		empId.sendKeys(eId);
		saveButton();
		waitForWebElementToAppear(infoToastContainer);
		String isaddedSuccessfully = infoToastContainer.getText();
		return isaddedSuccessfully;

	}
	
	public String addEmp(String fName, String lName) throws AWTException {
		empFirstName.sendKeys(fName);
		empLastName.sendKeys(lName);
		saveButton();
		waitForWebElementToAppear(infoToastContainer);
		String isaddedSuccessfully = infoToastContainer.getText();
		return isaddedSuccessfully;

}
}