package orangehrm.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangehrm.pageobjects.DashboardPage;
import orangehrm.pageobjects.PIMAddEmployeePage;
import orangehrm.pageobjects.PIMEdiEmployeePage;
import orangehrm.pageobjects.PIMEmployeeListingPage;
import orangehrm.tests.TestComponent.BaseTest;
import orangehrm.tests.TestComponent.Retry;

public class PIM extends BaseTest{

	@Test(dataProvider="getNewEmpData")
	public void pimAddEmpTest(String fName, String MName, String lName, String empId, String filePath) throws InterruptedException, AWTException, IOException {
		

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
		PIMEmployeeListingPage pimlisting = dp.goToPIM();
		PIMAddEmployeePage addEmpPage = pimlisting.addEmpButton();
//		String filePath = "C:\\Users\\52300409\\Downloads\\ohrm_branding.png";
		String isAddedSuccessfully = addEmpPage.addEmp(fName, MName, lName, empId, filePath);
		Assert.assertEquals(isAddedSuccessfully, "Successfully Saved");
		
//		No Records Found, Successfully Deleted
	
	}
	
	@Test(dataProvider="getMandatoryEmpData")
	public void pimAddEmpTest(HashMap<String, String> input) throws InterruptedException, AWTException, IOException {
		

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
		PIMEmployeeListingPage pimlisting = dp.goToPIM();
		PIMAddEmployeePage addEmpPage = pimlisting.addEmpButton();
		String isAddedSuccessfully = addEmpPage.addEmp(input.get("fName"), input.get("lName"));
		Assert.assertEquals(isAddedSuccessfully, "Successfully Saved");
		
//		No Records Found, Successfully Deleted
	
	}
	
//	@Test(dependsOnMethods= {"pimAddEmpTest"})
	@Test(retryAnalyzer=Retry.class)
	public void pimEditEmpTest() throws InterruptedException, AWTException, IOException {
		

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
		PIMEmployeeListingPage pimlisting = dp.goToPIM();
		pimlisting.goToEmployeeList();
		PIMEdiEmployeePage editEmp = pimlisting.webTableEditAction("Virat", "0249");
		editEmp.goToJobDetails();
		boolean isSavedSuccessfully = editEmp.jobDetails("September", "2024", "18", "Automaton Tester", "Full-Time Permanent");
		Assert.assertTrue(isSavedSuccessfully);
		
	}
	
	@Test(enabled=false)
	public void pimDeleteEmpTest() throws InterruptedException, AWTException, IOException {
		

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
		PIMEmployeeListingPage pimlisting = dp.goToPIM();
		pimlisting.goToEmployeeList();
		String empResult = pimlisting.webTableDeleteAction("Bob John", "0341");
//		Assert.assertEquals(empResult, "No Records Found");
		Assert.assertEquals(empResult, "Successfully Deleted");
//		No Records Found, Successfully Deleted
	
	
	}
	
	@DataProvider
	public Object[][] getNewEmpData() {
		return new Object[][] {
			{"John", "M", "Narvy", "EMP001", "C:\\Users\\52300409\\Downloads\\ohrm_branding.png"}, 
			{"Harley", "K", "Cheema", "EMP002", "C:\\Users\\52300409\\Downloads\\ohrm_branding.png"}, 
			{"Sher", "M", "Narvy", "EMP003", "C:\\Users\\52300409\\Downloads\\ohrm_branding.png"}
			
		};
	}
	
	@DataProvider
	public Object[][] getMandatoryEmpData() {
		
		HashMap<String,String> hm1 = new HashMap<String,String> ();
		hm1.put("fName", "Abhi");
		hm1.put("lName", "Bindra");
		
		HashMap<String,String> hm2 = new HashMap<String,String> ();
		hm2.put("fName", "Rahul");
		hm2.put("lName", "Shetty");

		HashMap<String,String> hm3 = new HashMap<String,String> ();
		hm3.put("fName", "Ali");
		hm3.put("lName", "Gony");
		
		return new Object[][] {{hm1}, {hm2}, {hm3}};
		
//		return new Object[][] {
//			{"Abhi", "Bindra"},
//			{"Rahul", "Shetty"},
//			{"Ali", "Gony"}
//		};
	}
	
}
