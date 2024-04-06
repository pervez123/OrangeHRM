package orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class DashboardPage extends ResuableComponents {
	
	WebDriver driver;
	
	@FindBy(css=".oxd-topbar-header-breadcrumb-module")
	WebElement breadCrumb;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getBreadcrumb() {
		return breadCrumb.getText();
	}

	public Admin_UsersPage goToAdmin() {
		sideMenuToBeClicked("Admin");
		Admin_UsersPage userPage = new Admin_UsersPage(driver);
		return userPage;
	}
	
	public PIMEmployeeListingPage goToPIM() {
		sideMenuToBeClicked("PIM");
		PIMEmployeeListingPage pimlisting = new PIMEmployeeListingPage(driver);
		return pimlisting;
	}
	
	
}
