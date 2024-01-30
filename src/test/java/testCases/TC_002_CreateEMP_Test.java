package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AddEmployee;
import pageObjects.EmployeeList;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_CreateEMP_Test extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	@Parameters({ "firstname", "lastname" })
	public void test_CreateEmp(String fname, String lname) {

		try {
			LoginPage lp = new LoginPage(driver);
			lp.setUserId(pr.getProperty("userName"));
			System.out.println("Test");
			lp.setPassword(pr.getProperty("password"));
			lp.clickLogin();

			HomePage hp = new HomePage(driver);
			hp.clickPIM();
			hp.clickAddEmployee();

			AddEmployee ae = new AddEmployee(driver);
			ae.setFirstName(fname);
			ae.setLastName(lname);
			String newEmpId = ae.getEmpId();
			System.out.println(newEmpId);
			Thread.sleep(3000);
			ae.clickSave();
			System.out.println("User created");
			
			Thread.sleep(3000);

			EmployeeList el = new EmployeeList(driver);
//			hp.clickPIM();
			
			Thread.sleep(5000);
			
			hp.clickEmployeeList();
			Thread.sleep(5000);
			el.empsearch_id(newEmpId);
			System.out.println("clicked new id");
			Thread.sleep(3000);
			el.clickSearch();
			Thread.sleep(5000);
			String empids = el.createdIdValidation();
			System.out.println(empids);

			if (empids == newEmpId) {
				System.out.println(empids);
				Assert.assertEquals(empids, newEmpId);
				
			} else {
				Assert.fail("New Emp not found");
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
