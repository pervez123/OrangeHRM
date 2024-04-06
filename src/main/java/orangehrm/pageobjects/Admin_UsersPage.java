package orangehrm.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class Admin_UsersPage extends ResuableComponents {

	WebDriver driver;
	public Admin_UsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	//driver.findElement(By.cssSelector(".orangehrm-header-container button")).click();
//	@FindBy(css=".orangehrm-header-container button")
//	WebElement addButton;
	
	
//	WebElement alertPopup = driver.findElement(By.cssSelector(".oxd-text--toast-title"));
//	wait.until(ExpectedConditions.visibilityOf(alertPopup));
//	
	@FindBy(css=".oxd-text--toast-title")
	WebElement alertPopupElement;

	public void goToAdminPage() {
		
		String sideMenu = "admin";
		// Converting first word to upperCase and rest of the letters in lower case.
//		sideMenuToBeClicked(sideMenu.substring(0,1).toUpperCase() + sideMenu.substring(1).toLowerCase());
		sideMenuToBeClicked(sideMenu);
	}
	
	public Admin_AddUsersPage addUserButton() {
//		waitForWebElementToAppear(addButton);
		
		// calling addButton() from parent class
		addButton();
		Admin_AddUsersPage addUser = new Admin_AddUsersPage(driver);
		return addUser;
	}

	public boolean alertPopup(String expectedPopupMessage) {
		waitForWebElementToAppear(alertPopupElement);
		return alertPopupElement.getText().contains(expectedPopupMessage);
	}
	
	
	public void colSorting(String colName) {
		
		sortingWebTable(colName);
		
	}

}

