package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	private static WebElement element = null;
	private static String address;
	
	//TODO - the following static methods are meant to be called without instantiating a LandingPage class. 
	//It's used for targetting.
	//These would have to be changed for the landing page locators, maybe with not just with ids but with xpaths
	public static WebElement link_MyAccount(WebDriver driver) {
		element = driver.findElement(By.id("account"));
		return element;
	}
	
	public static WebElement link_LogOut(WebDriver driver) {
		element = driver.findElement(By.id("account_logout"));
		return element;
	}
	
	public static String address_LandingPage(WebDriver driver) {
		address = driver.getCurrentUrl();
		return address;
	}
}
