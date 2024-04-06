package orangehrm.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangehrm.pageobjects.DashboardPage;
import orangehrm.tests.TestComponent.BaseTest;

public class Login extends BaseTest{

	
		@Test
		public void loginTest() {

		// fetching credentials from login page
		String vUsername = login.username.getText().split(":")[1].trim();
		String vPassword = login.password.getText().split(":")[1].trim();
		DashboardPage dp = login.login(vUsername, vPassword);
		Assert.assertEquals(dp.getBreadcrumb(),"Dashboard");
	
	}
		
		@Test(dataProvider= "getInvalidData")
		public void loginTest(HashMap<String, String> input) {

		login.login(input.get("email"), input.get("password"));
		Assert.assertEquals(login.getErrorAlert(), "Invalid credentials");
		
	
	}
		@DataProvider
		public Object[][] getInvalidData() throws IOException {
			
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//orangehrm//data//LoginData.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}, {data.get(2)}};
			//			return new Object[][] {{"Invalid", "admin123"}, {"Admin", "invalid"}, {"invalid", "invalid"}};
		}
}
