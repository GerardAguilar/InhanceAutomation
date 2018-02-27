package applicationModules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.LandingPage;
import utility.ExcelUtils;
import static org.testng.Assert.*;

public class LoadPage_Action {
	public static void Execute(WebDriver driver, String htmlAddress) {
		//www.inhance.com is a placeholder
		//Check if the page loads the proper address
		//Needs to work no matter the driver, the htmlAddress, and the page
		driver.navigate().to(htmlAddress);
		LandingPage.address_LandingPage(driver).equals(htmlAddress);//I don't like this part, since we can't re-use LoadPage Action for the other pages
		
	}
	public static void Execute(WebDriver driver) {
		//www.inhance.com is a placeholder
		//Check if the page loads the proper address
		//Needs to work no matter the driver, the htmlAddress, and the page
		String htmlAddress;
		try {
			htmlAddress = ExcelUtils.getCellData(1, 1);
			driver.navigate().to(htmlAddress);
			LandingPage.address_LandingPage(driver).equals(htmlAddress);//I don't like this part, since we can't re-use LoadPage Action for the other pages
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}		
	}
}
