package orangehrm.AbstractComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResuableComponents {
	
	WebDriver driver;
	public ResuableComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.xpath("//div[@class='oxd-table-header-sort']"));
	@FindBy(xpath="//div[@class='oxd-table-header-sort']")
	WebElement hearderSortingIcon;
	
	@FindBy(css=".orangehrm-header-container button")
	WebElement addButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//button[@type='button' and text()=' Cancel ']")
	WebElement cancelBtn;

	@FindBy(css = "#oxd-toaster_1 p:last-of-type")
	protected
	WebElement infoToastContainer;
	
	@FindBy(css=".oxd-autocomplete-option span")
	List<WebElement> dropdownOptions;
	
	@FindBy(css=".oxd-select-dropdown")
	protected
	WebElement selectDropdown;
	
	@FindBy(css=".oxd-select-option span")
	protected
	List<WebElement> selectDropdownOption;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public void waitForWebElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForAllWebElementToAppear(List <WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
	
	public void sideMenuToBeClicked(String moduleName) {
		String moduleNameToBeClicked = moduleName.substring(0,1).toUpperCase() + moduleName.substring(1).toLowerCase();
		WebElement sideMenu = driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a[contains(@href,'view" + moduleNameToBeClicked +"')]"));
		waitForWebElementToAppear(sideMenu);
		sideMenu.click();
		//li[@class='oxd-main-menu-item-wrapper']/a[contains(@href,'viewAdmin')]
	}
	
	
	
	public JavascriptExecutor scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	public void sortingWebTable(String headerName) {
		if(hearderSortingIcon.findElement(By.xpath("parent::div")).getText().equalsIgnoreCase(headerName)) {
			
			hearderSortingIcon.click();
		}
		
		
		
	}
	
	public void addButton() {
		addButton.click();
	}
	
	public void saveButton() {
		submitBtn.click();
	}
	
	public void cancelButton() {
		cancelBtn.click();
	}
	
	public Actions actions() {
		Actions act = new Actions(driver);
		return act;
	}
	
	public void uploadFile(WebElement ele, String filePath) throws AWTException {
		
		ele.click();
		Robot rb = new Robot();
		rb.delay(2000);
		// put file path to clip board
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Press CONTROL + V in the file name field on desktop window popup
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		//Release CONTROL + V
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		//Press ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
