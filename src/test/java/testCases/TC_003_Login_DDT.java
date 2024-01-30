package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_DDT extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	
	public void test_loginDDT(String userid,String pwswd,String exp) {
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		try {
			lp.setUserId(userid);
			lp.setPassword(pwswd);
			lp.clickLogin();
			
			System.out.println("test");
			
			boolean res= hp.isAdminModuleDisplayed();
			
			if(exp.equalsIgnoreCase("valid")) {
				if(res==true) {
					hp.clickWelcome();
					hp.clickLogout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(res==true) {
					hp.clickWelcome();
					hp.clickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("Exception Occured::"+e.getMessage());
		}
		
	}

}
