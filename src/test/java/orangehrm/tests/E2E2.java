package orangehrm.tests;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.pageobjects.DashboardPage;
import orangehrm.pageobjects.LoginPage;
import orangehrm.pageobjects.PIMEmployeeListingPage;
import orangehrm.tests.TestComponent.BaseTest;

public class E2E2 extends BaseTest{

	@Test
	public void pimAddEmp() throws InterruptedException {
		

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
//		Admin_UsersPage userListingPage = dp.goToAdmin();
//		Admin_AddUsersPage addUser = userListingPage.addUserButton();
//		addUser.userInfo("Admin", "Test", "Enabled", "QaEngineer1", "QaEngineer@123");
//		boolean ActualalertPopupMessage = userListingPage.alertPopup("Success");
//		Assert.assertTrue(ActualalertPopupMessage);
		PIMEmployeeListingPage pimlisting = dp.goToPIM();
		Thread.sleep(2000);
//		PIMAddEmployeePage addEmpPage = pimlisting.addEmpButton();
//		String filePath = "C:\\Users\\52300409\\Downloads\\ohrm_branding.png";
//		addEmpPage.addEmp("Mr.", "Swe", "Shawn", "123AbC", filePath);
		pimlisting.goToEmployeeList();
		String empResult = pimlisting.webTableDeleteAction("Orange", "001");
		Assert.assertEquals(empResult, "No Records Found");
		
//		No Records Found, Successfully Deleted
		driver.close();
	
	}
}
