package orangehrm.pageobjects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import orangehrm.AbstractComponents.ResuableComponents;

public class PIMEdiEmployeePage extends ResuableComponents {

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
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-navigation']//a[contains(@href,'Job')]")
	WebElement editEmpJobMenu;
	
	@FindBy(css=".oxd-input:nth-child(1)")
	WebElement joinedDate;
	
	@FindBy(css = ".oxd-calendar-selector-month-selected")
	WebElement calenderMonthDropdown;
	
	@FindBy(css = ".oxd-calendar-selector-year-selected")
	WebElement calenderYearDropdown;
	
	@FindBy(css=".oxd-calendar-dropdown--option")
	List<WebElement> calenderOptions;
	
	@FindBy(css=".oxd-calendar-date")
	List<WebElement> calenderDates;
	
	@FindBy(css=".oxd-icon-button i.bi-chevron-right")
	WebElement calenderNextBtn;

	@FindBy(css=".oxd-switch-input")
	WebElement empContractDetailsCheckbox;
	
	@FindBy(css=".oxd-label")
	List<WebElement> fieldsLabel;
	
	@FindBy(css=".oxd-loading-spinner")
	WebElement spinnerJobDetails;
	
//	@FindBy(xpath="//label[@class='oxd-label']")
//	List<WebElement> fieldsLabel;

	public PIMEdiEmployeePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
//	public void EmpDetails(String updatedFName, String updatedMidName, String lName, String eId, String filePath) throws AWTException {
//		empFirstName.sendKeys(fName);
//		empMidName.sendKeys(midName);
//		empLastName.sendKeys(lName);
//		uploadFile(empImage, filePath);
//		waitForWebElementToAppear(empId);
//		empId.clear(); // need to check why field is not clearing
//		empId.sendKeys(eId);
//		saveButton();
//
//	}
	
	public void goToJobDetails() {
		editEmpJobMenu.click();
	}
	
	public boolean jobDetails(String joiningMonth, String joiningYear, String joiningDate, String jobTitle, String employmentStatus) throws InterruptedException {
		
		Thread.sleep(1000);
		joinedDate.click();
		calenderMonthDropdown.click();
		calenderOptions.stream().filter(month-> month.getText().equalsIgnoreCase(joiningMonth)).findFirst().ifPresentOrElse(month-> month.click(), () -> {throw new NoSuchElementException("Month not found");});
		Thread.sleep(1000);
		calenderYearDropdown.click();
		calenderOptions.stream().filter(year-> year.getText().contains(joiningYear)).findFirst().ifPresentOrElse(year-> year.click(), () -> {throw new NoSuchElementException("Year not found");});
		calenderDates.stream().filter(date-> date.getText().contains(joiningDate)).findFirst().ifPresentOrElse(date-> date.click(), () -> {throw new NoSuchElementException("Date not found");});
		JavascriptExecutor js = scrollBy();
		js.executeScript("window.scrollBy(0, -350);");
		
//		for (WebElement fieldName: fieldsLabel) {
		
			fieldsLabel.stream().filter(field->field.getText().equalsIgnoreCase("Job Title")).findFirst().ifPresent(field -> {
				driver.findElement(with(By.tagName("div")).below(field)).click();
				waitForWebElementToAppear(selectDropdown);
				selectDropdownOption.stream().filter(title->title.getText().equalsIgnoreCase(jobTitle)).findFirst().ifPresentOrElse(title->title.click(), ()->{new NoSuchElementException("Job Title not found");});
				waitForElementToDisappear(spinnerJobDetails);
			});
			
			fieldsLabel.stream().filter(field->field.getText().equalsIgnoreCase("Employment Status")).findFirst().ifPresent(field -> {
				driver.findElement(with(By.tagName("div")).below(field)).click();
				waitForWebElementToAppear(selectDropdown);
				for (WebElement option: selectDropdownOption) {
					if (option.getText().equalsIgnoreCase(employmentStatus)) { 
						option.click();
						break;
					}
				}
//				selectDropdownOption.stream().filter(title->title.getText().equalsIgnoreCase(employmentStatus)).findAny().ifPresentOrElse(title->title.click(), ()->{new NoSuchElementException("Emp status not found");});
			});
		
		saveButton();
		waitForWebElementToAppear(infoToastContainer);
		boolean isSavedSuccessfully = infoToastContainer.getText().contains("Success");
		return isSavedSuccessfully;
		
	}

}
