package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


//import Pages to be tested
import pageObjects.LandingPage;

//import Application Modules
import applicationModules.LoadPage_Action;

public class POM_TC {
    private static WebDriver driver = null;
    
    public static void main(String[] args) {

    driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // TODO - Call the loaded Page's methods now to test
    LoadPage_Action.Execute(driver, "www.inhance.com");

    driver.quit();

    }
}
