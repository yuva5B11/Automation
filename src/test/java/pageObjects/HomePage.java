package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Admin") WebElement lnkAdmin;
	
	@FindBy(linkText = "PIM") WebElement lnkPIM;
	
	@FindBy(linkText = "Add Employee") WebElement lnkAddEmployee;
	
	@FindBy(linkText = "Employee List") WebElement lnkEmployeeList;
	
	@FindBy(partialLinkText = "Welcome") WebElement lnkWelcome;
	
	@FindBy(partialLinkText = "Logout") WebElement lnkLogout;
	
	public boolean isAdminModuleDisplayed() {
		try {
			return lnkAdmin.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickPIM() {
		lnkPIM.click();
	}
	
	public void clickAddEmployee() {
		lnkAddEmployee.click();
	}
	
	public void clickEmployeeList() {
		lnkEmployeeList.click();
	}
	
	public void clickWelcome() {
		lnkWelcome.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

}
