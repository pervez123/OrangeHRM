package orangehrm.pageobjects;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class PIMEmployeeListingPage extends ResuableComponents {

	WebDriver driver;

	public PIMEmployeeListingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'oxd-table-row')]")
	List<WebElement> webTableRows;

	@FindBy(css = ".oxd-topbar-body-nav-tab:nth-child(2)")
	WebElement employeeList;

	@FindBy(xpath = "//i[contains(@class,'bi-pencil-fill')]/parent::button")
	List<WebElement> editButton;

	@FindBy(css = ".oxd-button--label-danger")
	WebElement deletePopupOkbtn;

	@FindBy(css = ".oxd-button--text")
	WebElement deletePopupCancelbtn;

	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	WebElement inputEmpName;

	@FindBy(xpath = "(//label[@class='oxd-label'])[2]")
	WebElement employeeId;

	@FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-dropdown')]/div/span")
	List<WebElement> empNameDropdown;

	@FindBy(xpath = "//i[contains(@class,'bi-chevron-right')]/parent::button")
	WebElement paginationNextBtn;

	public PIMAddEmployeePage addEmpButton() {
		addButton();
		PIMAddEmployeePage addEmpPage = new PIMAddEmployeePage(driver);
		return addEmpPage;
	}

	public void goToEmployeeList() {
		employeeList.click();
	}

	public PIMEdiEmployeePage webTableEditAction(String empFName, String empId) {

//		for (WebElement rows: webTableRows) {
//			
//			String val = rows.findElement(By.xpath("div[3]/div")).getText();
//
//			if (rows.findElement(By.xpath("div[2]/div")).getText().contains(empId) && val.equalsIgnoreCase(empFName)) 
//			{
//				rows.findElement(By.xpath("div[9]//button[2]")).click();
//				break;
//			}
//		}
		List<WebElement> recordFound;
		do {

			recordFound = webTableRows.stream().filter(row -> {
				boolean isEmpNamePresent = row.findElement(By.xpath("div[3]/div")).getText().equalsIgnoreCase(empFName);
				boolean isEmpIdPresent = row.findElement(By.xpath("div[2]/div")).getText().contains(empId);
				return isEmpNamePresent && isEmpIdPresent;
			}).collect(Collectors.toList());

			if (recordFound.size() < 1) {
				try {
					paginationNextBtn.click();
				} catch (NoSuchElementException e) {
					System.out.println("No Data Available");
					break;
				}
			} else
				recordFound.stream().findAny()
						.ifPresentOrElse(record -> {
							WebElement editButton = record.findElement(By.xpath("div[9]//button[2]"));
				            // Scroll to the element
				            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
				            // Click on the edit button
				            editButton.click();}, () -> {
//								record.findElement(By.xpath("div[9]//button[2]")).click(),
						
							throw new NoSuchElementException("Record not found");
						});

		} while (recordFound.size() < 1);
		PIMEdiEmployeePage editEmp = new PIMEdiEmployeePage(driver);
		return editEmp;
	}

	public void searchEmpByNameAndId(String empName, String id) throws InterruptedException {
		inputEmpName.sendKeys(empName);
//		Thread.sleep(2000);
//		Actions act = actions();
//		act.sendKeys(Keys.TAB).sendKeys(id);

		driver.findElement(
				with(By.tagName("input")).below(driver.findElement(By.xpath("(//label[@class='oxd-label'])[2]"))))
				.sendKeys(id);
//		employeeIdInputField.sendKeys(id);

//		waitForAllWebElementToAppear(empNameDropdown);
//		empNameDropdown.stream().filter(eName -> eName.getText().contains(empName)).findFirst().ifPresentOrElse(suggestion->suggestion.click(), null);
		saveButton();
	}

	public String webTableDeleteAction(String empFName, String empId) throws InterruptedException {

		String info = null;
		searchEmpByNameAndId(empFName, empId);
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		JavascriptExecutor js = scrollBy();
		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> result = webTableRows.stream()
				.filter(row -> row.findElement(By.xpath("div[2]/div")).getText().contains(empId))
				.collect(Collectors.toList());

		if (result.size() < 1) {

			info = infoToastContainer.getText();

		} else {
			result.stream().findFirst().ifPresent(row -> row.findElement(By.xpath("div[9]//button[1]")).click());

			waitForWebElementToAppear(deletePopupOkbtn);
			deletePopupOkbtn.click();
			waitForWebElementToAppear(infoToastContainer);
			info = infoToastContainer.getText();
		}
		return info;

	}

}
