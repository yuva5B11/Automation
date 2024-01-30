package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_Login_test extends BaseClass{
	
	
	
	@Test(groups = {"Regression","Master"})
	public void test_Hrms_Login() {
		
		logger.debug("TC_001_Start here");
		
	try {
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.setUserId(pr.getProperty("userName"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLogin();
		
		boolean res=hp.isAdminModuleDisplayed();
		
		if(res) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
		
		
	} catch (Exception e) {
		Assert.fail(e.getMessage());
	}
	}

}
