package orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangehrm.AbstractComponents.ResuableComponents;

public class TimePage extends ResuableComponents{
	
	WebDriver driver;
	
	@FindBy(css=".oxd-label")
	WebElement labelEmpName;
	
	@FindBy(css = ".oxd-button:first-child")
	WebElement cancelBtn;
	public TimePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
