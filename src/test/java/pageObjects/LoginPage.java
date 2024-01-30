package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="txtUsername") WebElement txtUserId;
	@FindBy(id="txtPassword") WebElement txtPwd;
	
	@FindBy(id="btnLogin") WebElement btnLogin;
	
	public void setUserId(String uid) {
		txtUserId.sendKeys(uid);
	}
	
	public void setPassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}
