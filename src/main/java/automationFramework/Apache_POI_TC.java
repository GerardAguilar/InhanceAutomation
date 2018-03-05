package automationFramework;

	import java.io.File;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	import pageObjects.*;
	import utility.Constant;
	import utility.ExcelUtils;
	import applicationModules.LoadPage_Action;

public class Apache_POI_TC {
	private static WebDriver driver = null;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {	
		ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("geckodriver.exe");
        String os = System.getProperty("os.name").toLowerCase();
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File geckodriver;

        //In the case of a MAC, we may need to copy the tar.gz file and then reference the resulting geckodriver application
        if(os.contains("mac")) {
            geckodriver = new File(System.getProperty("user.dir") + "/geckodriver");  
        }else {
        	geckodriver = new File("Driver" + "\\geckodriver.exe"); 
            if (!geckodriver.exists()) {
            	geckodriver.createNewFile();
                FileUtils.copyURLToFile(resource, geckodriver);
            }
        }

        String geckodriverLocation = geckodriver.getAbsolutePath();        
        System.setProperty("webdriver.gecko.driver", geckodriverLocation);
        
//	    driver = new FirefoxDriver();
//	    baseUrl = "http://www.inhance.com/";
//	    driver.get(baseUrl);
//	    driver.manage().window().maximize(); 
////	    driver.manage().window().setSize(new Dimension(1024, 768))
//	    wait = new WebDriverWait(driver, 20);
	}
	
	@Test
	public void test() {
		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		driver.navigate().to(Constant.URL);
		LoadPage_Action.Execute(driver);
		System.out.println("Navigation successful");
		driver.quit();
//		try {
//			ExcelUtils.setCellData("Pass", 1,3);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
//	public static void main(String[] args) throws Exception{
//		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
//		driver.navigate().to(Constant.URL);
//		LoadPage_Action.Execute(driver);
//		System.out.println("Navigation successful");
//		driver.quit();
//		ExcelUtils.setCellData("Pass", 1,3);
//	}
}
