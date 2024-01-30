package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee extends BasePage{
	
	public AddEmployee(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="firstName") WebElement txtFirstName;
	
	@FindBy(id="lastName") WebElement txtLastName;
	
	@FindBy(id="employeeId") WebElement valEmployeeId;
	
	@FindBy(id="btnSave") WebElement btnSave;
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public String getEmpId() {
		return valEmployeeId.getText();
	}
	
	public void clickSave() {
		btnSave.click();
	}

}
