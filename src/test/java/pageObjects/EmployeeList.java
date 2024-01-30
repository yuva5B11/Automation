package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeList extends BasePage{
	
	public EmployeeList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath =  "//input[@id='empsearch_id']") WebElement txtEmpSearchId;
	
	@FindBy(id = "searchBtn") WebElement btnSearch;
	
	@FindBy(id = "resultTable") WebElement listIds;
	
	
	
	public void empsearch_id(String nempid) {
		txtEmpSearchId.sendKeys(nempid);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	public String createdIdValidation() {
		List<WebElement> empids= listIds.findElements(By.tagName("td"));
		
		for (WebElement x : empids) {
			System.out.println(x.getText());
			return x.getText();
		}
		return null;
	}

}
